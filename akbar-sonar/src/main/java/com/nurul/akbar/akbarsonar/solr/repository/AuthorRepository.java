package com.nurul.akbar.akbarsonar.solr.repository;

import com.nurul.akbar.akbarsonar.solr.pojo.Author;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface AuthorRepository extends SolrCrudRepository<Author,String> {
}
