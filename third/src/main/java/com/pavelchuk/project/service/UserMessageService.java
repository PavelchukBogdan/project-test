package com.pavelchuk.project.service;

import dto.UserMessageDto;
import dto.UserMessageWithHashDto;
import org.springframework.stereotype.Service;

@Service
public interface UserMessageService {

   UserMessageWithHashDto generateResponseMessage(UserMessageDto dto);
}

