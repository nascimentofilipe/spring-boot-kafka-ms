package com.dev.api.message;

import com.dev.api.dto.CarPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerMessage {

    @Autowired
    private KafkaTemplate<String, CarPostDto> kafkaTemplate; //usado pra enviar messagem pro topic

    private final String KAFKA_TOPIC = "car-post-topic";

    public void sendMessage(CarPostDto carPostDto) {
        kafkaTemplate.send(KAFKA_TOPIC, carPostDto);
    }
}
