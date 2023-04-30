package org.example.Produser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.util.Measurement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class TopicProduser {
    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, Measurement> kafkaTemplate;

    public void send(String message){
        log.info("Payload: {}", message);
    }

    public void sendMea(Measurement measurement){
        log.info("Payload: {}", measurement.toString());
        kafkaTemplate.send(topicName, measurement);
    }
}
