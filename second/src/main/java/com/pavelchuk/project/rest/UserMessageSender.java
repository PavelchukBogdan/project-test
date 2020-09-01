package com.pavelchuk.project.rest;

import com.pavelchuk.project.service.UserMessageWithHashDtoService;
import dto.UserMessageDto;
import dto.UserMessageWithHashDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class UserMessageSender {

    private final RestTemplate restTemplate;
    private final UserMessageWithHashDtoService userMessageWithHashDtoService;
    private String URL;
    private final String CONTENT_TYPE = "Content-Type";

    @Value("${service3.host}")
    private void setURL(String URL) {
        this.URL = URL;
    }

    @Autowired
    public UserMessageSender(RestTemplate restTemplate, UserMessageWithHashDtoService userMessageWithHashDtoService) {
        this.restTemplate = restTemplate;
        this.userMessageWithHashDtoService = userMessageWithHashDtoService;
    }

    public void sendMessage(UserMessageDto dto){
        HttpHeaders headers = getHttpHeaders();
        try {
            ResponseEntity<UserMessageWithHashDto> response = restTemplate.exchange(URL, HttpMethod.POST, new HttpEntity<>(dto, headers), UserMessageWithHashDto.class);
            HttpStatus statusCode = response.getStatusCode();
            userMessageWithHashDtoService.saveMessage(response.getBody());
            if (statusCode.equals(HttpStatus.OK)) {
                log.info("Объект успешно отправлен");
            } else {
                log.error("При отправки сообщения произошла ошибка: " + statusCode);
            }
        }
        catch (RestClientException e) {
            log.error("При отправке сообщения произошла ошибка: " + e.getMessage());
        }
    }

    private HttpHeaders getHttpHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }
}
