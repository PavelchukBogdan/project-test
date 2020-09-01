package com.pavelchuk.project.listener;

import com.pavelchuk.project.rest.UserMessageSender;
import dto.UserMessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    private final UserMessageSender sender;

    @Autowired
    public Listener( UserMessageSender userMessageSender){
        this.sender = userMessageSender;
    }

    @KafkaListener(topics="message", groupId = "app.1", containerFactory = "userMessageKafkaListenerContainerFactory")
    public void msgListener(UserMessageDto dto){
        sender.sendMessage(dto);
    }

}
