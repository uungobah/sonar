package com.nurul.akbar.akbarsonar.solr.repository;

import com.nurul.akbar.akbarsonar.solr.pojo.TwitterData;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface TwitterDataRepository extends SolrCrudRepository<TwitterData,String> {
}
