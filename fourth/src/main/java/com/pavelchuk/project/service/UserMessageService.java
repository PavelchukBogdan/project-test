package com.pavelchuk.project.service;

import dto.UserMessageWithHashDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserMessageService {
    List<UserMessageWithHashDto> getAllMessage(Long from, Long to);
}
