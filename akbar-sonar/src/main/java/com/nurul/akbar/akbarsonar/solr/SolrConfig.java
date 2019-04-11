package com.nurul.akbar.akbarsonar.solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(
        basePackages = "com.nurul.akbar.akbarsonar.solr.repository"
)
@ComponentScan
public class SolrConfig {

    @Value("${solr.url}")
    private String urlString;

    @Bean
    public SolrClient solrClient() {

        HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
        return solr;
    }

    @Bean
    public SolrTemplate solrTemplate(SolrClient client) throws Exception {
        return new SolrTemplate(client);
    }
}
