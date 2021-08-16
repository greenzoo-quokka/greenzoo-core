package com.greenzoo.oauth2.greenzoooauth2.oauth2.userinfo;

import java.util.Map;

public class NaverOAuth2UserInfo extends OAuth2UserInfo {

    public NaverOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        String response = null;
        if(attributes.containsKey("id")){
            response = attributes.get("id").toString();
        }
        return response;
    }

    @Override
    public String getName() {
        String response = null;
        if(attributes.containsKey("name")){
            response = attributes.get("name").toString();
        }
        return response;
    }

    @Override
    public String getEmail() {
        String response = null;
        if(attributes.containsKey("email")){
            response = attributes.get("email").toString();
        }
        return response;
    }

    @Override
    public String getImageUrl() {
        String response = null;
        if(attributes.containsKey("profile_image")){
            response = attributes.get("profile_image").toString();
        }
        return response;
    }

    public String getPhoneNum() {
        String response = null;
        if(attributes.containsKey("mobile")){
            response = attributes.get("mobile").toString();
        }
        return response;
    }
}
