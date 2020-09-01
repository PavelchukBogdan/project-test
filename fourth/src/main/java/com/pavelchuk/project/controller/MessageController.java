package com.pavelchuk.project.controller;

import com.pavelchuk.project.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final UserMessageService userMessageService;

    @Autowired
    public MessageController(UserMessageService userMessageService) {
        this.userMessageService = userMessageService;
    }

    @GetMapping
    public ResponseEntity<?> getMessages(Long from, Long to){
        return ResponseEntity.ok(userMessageService.getAllMessage(from, to));

    }
}
