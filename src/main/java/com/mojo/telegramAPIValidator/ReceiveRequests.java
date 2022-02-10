package com.mojo.telegramAPIValidator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/")
public class ReceiveRequests {
    Validator validator = new Validator();
    RequestResponse requestResponse = new RequestResponse();
    @Value("${telegram.key}")
    private String telegramKey;
    @Value("${telegram.channel}")
    private String telegramChannel;

    @CrossOrigin(origins = "*")
    @PostMapping("sendMessage")
    public RequestResponse sendMessage(@RequestBody MessageRequest messageRequest) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);
        RequestResponse result = this.handleValidationAndResponse(messageRequest.getEmail(), messageRequest.getFullName(), messageRequest.getMsg());
        String string = "Name: "+ messageRequest.getFullName();
        string += "\nEmail: " +messageRequest.getEmail();
        if(messageRequest.getMsg().length() > 0) {
            string += "\nMessage: " + messageRequest.getMsg();
        }

        String url = "https://api.telegram.org/bot{key}/sendMessage?chat_id={channel}&text={text}";
        if (requestResponse.isSuccess()) {
            restTemplate.exchange(url, HttpMethod.POST, request, String.class,
                    telegramKey, telegramChannel, string);
        }
        return result;

    }

    @GetMapping("teleGet")
    public String telGet() {
        return "your in the get";
    }

    public RequestResponse handleValidationAndResponse(final String email, final String fullName, final String msg) {
        requestResponse.setValidEmail(validator.isValidEmail(email));
        requestResponse.setValidName(validator.isValidString(fullName, 3, 100));
        requestResponse.setValidMessage(validator.isValidString(msg, 0, 250));
        requestResponse.setSuccess((requestResponse.isValidEmail() && requestResponse.isValidName() && requestResponse.isValidMessage()));
        requestResponse.setMessage("Thank you for reaching out! I'll get back to you as soon as possible");
        if (!requestResponse.isSuccess()) {
            requestResponse.setMessage("Sorry you failed");
        }
        return requestResponse;
    }
}
