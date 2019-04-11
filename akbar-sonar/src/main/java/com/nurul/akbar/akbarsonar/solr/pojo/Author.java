package com.nurul.akbar.akbarsonar.solr.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "Author")
@lombok.Data
public class Author {

    @Id
    @Indexed(name = "authorId",type = "string")
    private String authorId;

    @Indexed(name = "source",type = "string")
    private String source;

    @Indexed(name = "userName",type = "string")
    private String userName;

    @Indexed(name = "screenName",type = "string")
    private String screenName;

    @Indexed(name = "description",type = "string")
    private String description;

    @Indexed(name = "socialMediaRole",type = "string")
    private String socialMediaRole;

    @Indexed(name = "urlUsername",type = "string")
    private String urlUsername;
}
