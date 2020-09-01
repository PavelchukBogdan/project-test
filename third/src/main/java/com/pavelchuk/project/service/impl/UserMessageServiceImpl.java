package com.pavelchuk.project.service.impl;

import com.pavelchuk.project.service.UserMessageService;
import dto.UserMessageDto;
import dto.UserMessageWithHashDto;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;


@Service
@PropertySource("classpath:application.properties")
public class UserMessageServiceImpl implements UserMessageService {

    @Override
    public UserMessageWithHashDto generateResponseMessage(UserMessageDto dto) {
        UserMessageWithHashDto userMessageWithHashDto = new UserMessageWithHashDto(dto.getUserName(), dto.getMessage());
        userMessageWithHashDto.setHash(userMessageWithHashDto.getUserName().hashCode());
        return userMessageWithHashDto;
    }

}
