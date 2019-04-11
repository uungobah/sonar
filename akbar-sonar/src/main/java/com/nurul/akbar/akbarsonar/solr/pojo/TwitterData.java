package com.nurul.akbar.akbarsonar.solr.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "TwitterData")
@lombok.Data
public class TwitterData {

    @Id
    @Indexed(name = "postId",type = "string")
    private String postId;

    @Indexed(name = "userName",type = "string")
    private String userName;

    @Indexed(name = "source",type = "string")
    private String source;

    @Indexed(name = "postUrl",type = "string")
    private String postUrl;

    @Indexed(name = "content", type = "string")
    private String content;

    @Indexed(name = "urlUsername", type = "string")
    private String urlUsername;

    @Indexed(name = "postType", type = "string")
    private String postType;

    @Indexed(name = "referencedPostId", type = "string")
    private String referencedPostId;

    @Indexed(name = "referencedPostUsername", type = "string")
    private String referencedPostUsername;

    @Indexed(name = "referencedPost", type = "string")
    private String referencedPost;

    @Indexed(name = "city", type = "string")
    private String city;

    @Indexed(name = "province", type = "string")
    private String province;

    @Indexed(name = "country", type = "string")
    private String country;

    @Indexed(name = "longitude", type = "string")
    private String longitude;

    @Indexed(name = "latitude", type = "string")
    private String latitude;

    @Indexed(name = "transactionDt", type = "string")
    private String transactionDt;

    @Indexed(name = "sentiment", type = "string")
    private String sentiment;

}
