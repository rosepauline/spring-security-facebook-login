package com.rosepauline;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.security.Principal;
import java.util.Map;

@RestController
public class BasicController {

    @GetMapping("/")
    public  String home(Principal principal){
        Map<String, Object> authDetails = (Map<String, Object>) ((OAuth2Authentication) principal)
                .getUserAuthentication()
                .getDetails();

        String userName = (String) authDetails.get("name");

                return "Hey" + userName + ", Welcome to My first oauth 2.0";
    }

}
