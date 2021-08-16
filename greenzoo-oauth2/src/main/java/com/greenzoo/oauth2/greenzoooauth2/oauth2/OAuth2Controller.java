package com.greenzoo.oauth2.greenzoooauth2.oauth2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.greenzoo.oauth2.greenzoooauth2.oauth2.userinfo.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class OAuth2Controller {

    @GetMapping({"", "/"})
    public String getAuthorizationMessage() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping({"/loginSuccess", "/hello"})
    public String loginSuccess(@AuthenticationPrincipal OAuth2User principal, Model model) throws JsonProcessingException {
        String social_type = principal.getAttribute("social_type");
        OAuth2UserInfo userInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(social_type, principal.getAttributes());
        ObjectMapper objectMapper = new ObjectMapper();
        if (principal != null) {
            Map<String, String> map = new HashMap<>();
            map.put("id", userInfo.getId());
            map.put("email", userInfo.getEmail());
            map.put("name", userInfo.getName());
            map.put("imageUrl", userInfo.getImageUrl());
            model.addAttribute("map", map);
        }
        return "hello";
    }

    @GetMapping("/loginFailure")
    public String loginFailure() {
        return "loginFailure";
    }

}
