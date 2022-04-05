package com.deepraj1729.coronavirustracker.services;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.deepraj1729.coronavirustracker.models.LocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CoronaVirusDataService {
    //Data URL for CoronaVirus (raw CSV)
    public String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    //Location Stats ArrayList from LocationStats
    private List<LocationStats> allStats = new ArrayList<>();

    //Getter for all LocationStats stored after "fetchVirusData" method is called
    public List<LocationStats> getAllStats() {
        return allStats;
    }

    @PostConstruct
    @Scheduled(cron = "1 * * * * *")
    public void fetchVirusData() throws IOException, InterruptedException {
        //List to store LocationStats for every GET request done in a scheduled time Using scheduler (Cron)
        List<LocationStats> newStats = new ArrayList<>();

        //HttpClient initializer
        HttpClient client = HttpClient.newHttpClient();

        //HttpRequest Builder from string (VIRUS_DATA_URL)
        HttpRequest request =  HttpRequest.newBuilder()
                .uri(URI.create(VIRUS_DATA_URL))
                .build();

        //Send HTTP GET Request
        HttpResponse<String> httpResponse =  client.send(request, HttpResponse.BodyHandlers.ofString());

        //Receive Response as a StringBody handled using 3rd-party maven package (commons-csv)
        StringReader csvBodyReader = new StringReader(httpResponse.body());

        //Set Iterable for the StringBody and parse it using the 3rd Party library (commons-csv)
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);

        //Iterate over the parsed CSV and get the row values
        for (CSVRecord record : records) {
            LocationStats locationStat = new LocationStats();
            locationStat.setState(record.get("Province/State"));
            locationStat.setCountry(record.get("Country/Region"));

            int latestCases = Integer.parseInt(record.get(record.size()-1));
            int prevDayCases = Integer.parseInt(record.get(record.size()-2));

            locationStat.setLatestTotalCases(prevDayCases);
            locationStat.setDiffFromPrevDay(latestCases-prevDayCases);
            newStats.add(locationStat);
        }
        //Save this new stats to the allStats for storing the locationStats that is going to be used for geAllStats()
        this.allStats = newStats;
    }
}
