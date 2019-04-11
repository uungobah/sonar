package com.nurul.akbar.akbarsonar.solr.serviceimpl;

import com.nurul.akbar.akbarsonar.solr.pojo.Author;
import com.nurul.akbar.akbarsonar.solr.pojo.TwitterData;
import com.nurul.akbar.akbarsonar.solr.repository.AuthorRepository;
import com.nurul.akbar.akbarsonar.solr.service.AuthorService;
import com.nurul.akbar.akbarsonar.utils.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    @Override
    public boolean save(String message) {

        JSONParser jsonParser = new JSONParser();
        try {
            Author author = new Author();

            JSONObject obj = (JSONObject) jsonParser.parse(message);


            JSONObject actor = (JSONObject) obj.get("actor");

            if (StringUtils.hasValue(actor.get("preferredUsername"))){
                author.setUserName(actor.get("preferredUsername").toString());
            }
            if (StringUtils.hasValue(actor.get("link"))){
                author.setUrlUsername(actor.get("link").toString());
            }
            if(StringUtils.hasValue(actor.get("displayName"))){
                author.setScreenName(actor.get("displayName").toString());
            }
            if(StringUtils.hasValue(actor.get("summary"))){
                author.setDescription(actor.get("summary").toString());
            }
            if(StringUtils.hasValue(actor.get("verified"))) {
                String role = (boolean) actor.get("verified") == true ? "Influencer" : "Person";
                author.setSocialMediaRole(role);
            }

            JSONObject provider = (JSONObject) obj.get("provider");
            if (StringUtils.hasValue(provider.get("displayName"))){
                author.setSource(provider.get("displayName").toString());
            }

            authorRepository.save(author);

            return true;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }


    }


}
