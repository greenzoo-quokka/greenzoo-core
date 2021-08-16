package com.greenzoo.oauth2.greenzoooauth2.oauth2.userinfo;

import java.util.Map;

public class KakaoOAuth2UserInfo extends OAuth2UserInfo {

    public KakaoOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        String returnString = null;
        if (attributes.containsKey("id")) {
            returnString = attributes.get("id").toString();
        }
        return returnString;
    }

    @Override
    public String getName() {
        String returnString = null;
        Map<String, Object> properties = (Map<String, Object>) attributes.get("kakao_account");
        properties = (Map<String, Object>)properties.get("profile");
        if(properties.containsKey("nickname")){
            returnString = properties.get("nickname").toString();
        }
        return returnString;
    }

    @Override
    public String getEmail() {
        String returnString = null;
        Map<String, Object> properties = (Map<String, Object>) attributes.get("kakao_account");
        if (properties.containsKey("email")) {
            returnString = properties.get("email").toString();
        }
        return returnString;
    }

    @Override
    public String getImageUrl() {
        Map<String, Object> properties = (Map<String, Object>) attributes.get("kakao_account");

        if (properties == null) {
            return null;
        }

        return (String) properties.get("thumbnail_image");
    }
}
