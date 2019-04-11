package com.nurul.akbar.akbarsonar.solr.serviceimpl;

import com.nurul.akbar.akbarsonar.solr.pojo.TwitterData;
import com.nurul.akbar.akbarsonar.solr.repository.TwitterDataRepository;
import com.nurul.akbar.akbarsonar.solr.service.TwitterDataService;
import com.nurul.akbar.akbarsonar.utils.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwitterDataServiceImpl implements TwitterDataService {
    @Autowired
    TwitterDataRepository twitterDataRepository;

    @Override
    public boolean save(String message) {
        JSONParser jsonParser = new JSONParser();
        try {
            TwitterData twitterData = new TwitterData();

            JSONObject obj = (JSONObject) jsonParser.parse(message);
            if (StringUtils.hasValue(obj.get("id"))) {
                twitterData.setPostId(obj.get("id").toString().replace("tag:search.twitter.com,2005:", ""));
            }
            if (StringUtils.hasValue(obj.get("link"))) {
                twitterData.setPostUrl(obj.get("link").toString());
            }
            if (StringUtils.hasValue(obj.get("body"))) {
                twitterData.setContent(obj.get("body").toString());
            }
            if (StringUtils.hasValue(obj.get("verb"))) {
                twitterData.setPostType(obj.get("verb").toString());
            }
            if (StringUtils.hasValue(obj.get("postedTime"))) {
                twitterData.setTransactionDt(obj.get("postedTime").toString());
            }


            JSONObject actor = (JSONObject) obj.get("actor");
            if (StringUtils.hasValue(actor.get("preferredUsername"))) {
                twitterData.setUserName(actor.get("preferredUsername").toString());
            }
            if (StringUtils.hasValue(actor.get("link"))) {
                twitterData.setUrlUsername(actor.get("link").toString());
            }


            JSONObject provider = (JSONObject) obj.get("provider");
            if (StringUtils.hasValue(provider.get("displayName"))) {
                twitterData.setSource(provider.get("displayName").toString());
            }


            if (obj.get("verb").toString().equals("share")) {
                JSONObject objRef = (JSONObject) obj.get("object");
                if (StringUtils.hasValue(objRef.get("id"))) {
                    twitterData.setReferencedPostId(objRef.get("id").toString().replace("tag:search.twitter.com,2005:", ""));
                }

                if (StringUtils.hasValue(objRef.get("body"))) {
                    twitterData.setReferencedPost(objRef.get("body").toString());
                }

                JSONObject actorRef = (JSONObject) objRef.get("actor");
                if (StringUtils.hasValue(actorRef.get("preferredUsername"))) {
                    twitterData.setReferencedPostUsername(actorRef.get("preferredUsername").toString());
                }

            }

            twitterDataRepository.save(twitterData);

            return true;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

    }
}
