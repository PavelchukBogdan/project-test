package com.pavelchuk.project.controller;

import com.pavelchuk.project.service.UserMessageService;
import dto.UserMessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class UserMessageController {

    private final UserMessageService userMessageService;

    @Autowired
    public UserMessageController(UserMessageService userMessageService) {
        this.userMessageService = userMessageService;
    }

    @PostMapping
    public ResponseEntity<?> acceptMessage(@RequestBody UserMessageDto dto) {
        return ResponseEntity.ok(userMessageService.generateResponseMessage(dto));

    }
}
