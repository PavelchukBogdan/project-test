package com.pavelchuk.project.service.impl;

import com.pavelchuk.project.domain.entity.UserMessage;
import com.pavelchuk.project.domain.mapper.UserMessageMapper;
import com.pavelchuk.project.domain.UserMessageRepository;
import com.pavelchuk.project.service.UserMessageWithHashDtoService;
import dto.UserMessageWithHashDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMessageWithHashDtoServiceImpl implements UserMessageWithHashDtoService {

    private final UserMessageRepository repository;

    @Autowired
    public UserMessageWithHashDtoServiceImpl(UserMessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveMessage(UserMessageWithHashDto dto) {
        UserMessage userMessage = UserMessageMapper.toEntity(dto);
        repository.save(userMessage);
    }
}
