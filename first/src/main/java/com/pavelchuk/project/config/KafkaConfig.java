package com.pavelchuk.project.config;

import dto.UserMessageDto;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    private String KAFKA_ADDRESS;

    @Value("${kafka.address}")
    private void setKafkaAddress(String KAFKA_ADDRESS){
        this.KAFKA_ADDRESS = KAFKA_ADDRESS;
    }

    @Bean
    public ProducerFactory<String, UserMessageDto> producerFactory(){
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,KAFKA_ADDRESS);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);

    }
    @Bean
    public KafkaTemplate<String, UserMessageDto> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
