package com.deepraj1729.coronavirustracker.controllers;

import com.deepraj1729.coronavirustracker.models.LocationStats;
import com.deepraj1729.coronavirustracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@Controller
public class HomeController {
    @Autowired
    CoronaVirusDataService dataService;

    @GetMapping("/")
    public String Home(Model model){
        List<LocationStats> allStats = dataService.getAllStats();

        int totalCases = allStats.stream().mapToInt(LocationStats::getLatestTotalCases).sum();
        int totalNewCases = allStats.stream().mapToInt(LocationStats::getDiffFromPrevDay).sum();

        String totalCases1 = NumberFormat.getNumberInstance(Locale.US).format(totalCases);
        String totalNewCases1 = NumberFormat.getNumberInstance(Locale.US).format(totalNewCases);

        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalCases1);
        model.addAttribute("totalNewCases", totalNewCases1);
        return "home";
    }
}
