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
    KafkaTemplate<String, Course> kafkaTemplate;


    public String sendMessage(Course course){
        String courseAsMessage = course.toString();
        kafkaTemplate.send(orderTopic, course);

        log.info("course sent {}", course);

        return "message sent";
    }
}
