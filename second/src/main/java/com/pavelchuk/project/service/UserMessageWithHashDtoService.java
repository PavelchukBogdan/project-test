package com.pavelchuk.project.service;

import dto.UserMessageWithHashDto;
import org.springframework.stereotype.Service;

@Service
public interface UserMessageWithHashDtoService {
    void saveMessage(UserMessageWithHashDto dto);
}
