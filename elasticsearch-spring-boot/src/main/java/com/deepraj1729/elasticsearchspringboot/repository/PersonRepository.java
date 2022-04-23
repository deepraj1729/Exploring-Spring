package com.deepraj1729.elasticsearchspringboot.repository;

import com.deepraj1729.elasticsearchspringboot.document.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PersonRepository extends ElasticsearchRepository<Person,String> {

}
