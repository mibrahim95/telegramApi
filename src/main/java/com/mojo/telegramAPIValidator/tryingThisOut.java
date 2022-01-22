package com.mojo.telegramAPIValidator;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@RestController
public class tryingThisOut {

    @RequestMapping("/sendToTelegram/{text}")
    public void HelloWorld(@PathVariable String text){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);

        String url = "https://api.telegram.org/bot{key}/sendMessage?chat_id={channel}&text={text}";
         restTemplate.exchange(url, HttpMethod.GET, request, String.class,"5087418917:AAF9FTVsp62CnsFLdlh-a1FzyblRn5FzmIk","@PortfolioContactRequests",text);

    }
}
