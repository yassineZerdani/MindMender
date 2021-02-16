package com.psybot.Controller;

import com.psybot.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/chat")
public class MessageController {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    RestTemplate restTemplate;
    //Post mapping to django rest API for data processing
    @PostMapping("/input")
    public ResponseEntity<?> processInput(String input){
        String output="";
       //String output = restTemplate.exchange("localhost:88888/", HttpMethod.POST,String input, String output);
        //output returned by django rest template
        return ResponseEntity.ok(output);
    }
}
