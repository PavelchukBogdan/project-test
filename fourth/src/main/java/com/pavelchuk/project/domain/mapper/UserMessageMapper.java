package com.pavelchuk.project.domain.mapper;

import com.pavelchuk.project.domain.entity.UserMessage;
import dto.UserMessageWithHashDto;


public class UserMessageMapper {

    public static UserMessageWithHashDto toDto(UserMessage userMessage){
        UserMessageWithHashDto dto = new UserMessageWithHashDto();
        dto.setHash(userMessage.getHash());
        dto.setMessage(userMessage.getMessage());
        dto.setTimestamp(userMessage.getTimestamp());
        dto.setUserName(userMessage.getUserName());
        dto.setId(userMessage.getId());
        return dto;
    }

}
