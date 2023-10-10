package com.metamorphosis.kafka.kafka;

import com.metamorphosis.kafka.entities.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Producer {
    @Value("${topic.name}")
    private String orderTopic;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;


    public String sendMessage(Course course){
        String courseAsMessage = course.toString();
        kafkaTemplate.send(orderTopic, courseAsMessage);

        log.info("course sent {}", courseAsMessage);

        return "message sent";
    }
}
