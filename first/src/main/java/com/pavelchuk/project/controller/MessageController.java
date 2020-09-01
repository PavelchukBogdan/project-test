package com.pavelchuk.project.controller;

import dto.UserMessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final KafkaTemplate<String, UserMessageDto> kafkaTemplate;
    private String TOPIC_MESSAGE;

    @Value("${topic.message}")
    private void setTopic(String TOPIC_MESSAGE){
        this.TOPIC_MESSAGE = TOPIC_MESSAGE;

    }

    @Autowired
    public MessageController(KafkaTemplate<String, UserMessageDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void sendOrder(@RequestBody UserMessageDto userMessageDto){
        kafkaTemplate.send(TOPIC_MESSAGE, userMessageDto);
    }

}


