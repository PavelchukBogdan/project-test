package com.pavelchuk.project.domain.mapper;

import com.pavelchuk.project.domain.entity.UserMessage;
import dto.UserMessageWithHashDto;

public class UserMessageMapper {

    public static UserMessage toEntity(UserMessageWithHashDto dto){
        UserMessage userMessage = new UserMessage();
        userMessage.setUserName(dto.getUserName());
        userMessage.setMessage(dto.getMessage());
        userMessage.setHash(dto.getHash());
        userMessage.setTimestamp(dto.getTimestamp());
        userMessage.setId(dto.getId());
        return userMessage;
    }
}