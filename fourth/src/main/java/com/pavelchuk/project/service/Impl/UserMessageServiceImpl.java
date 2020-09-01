package com.pavelchuk.project.service.Impl;

import com.pavelchuk.project.domain.entity.UserMessage;
import com.pavelchuk.project.domain.mapper.UserMessageMapper;
import com.pavelchuk.project.domain.repository.UserMessageRepository;
import com.pavelchuk.project.service.UserMessageService;
import dto.UserMessageWithHashDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserMessageServiceImpl implements UserMessageService {

    private final UserMessageRepository userMessageRepository;

    @Autowired
    public UserMessageServiceImpl(UserMessageRepository userMessageRepository) {
        this.userMessageRepository = userMessageRepository;
    }


    @Override
    public List<UserMessageWithHashDto> getAllMessage(Long from, Long to) {
        List<UserMessage> userMessages = userMessageRepository.findAllMessagesByInterval(from, to);
        List<UserMessageWithHashDto> dtos = new ArrayList<>();
        userMessages.forEach(userMessage -> dtos.add(UserMessageMapper.toDto(userMessage)));
        return dtos;


    }
}
