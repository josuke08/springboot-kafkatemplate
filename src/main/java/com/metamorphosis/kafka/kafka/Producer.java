package com.metamorphosis.kafka.kafka;

import com.metamorphosis.kafka.entities.Course;
import com.metamorphosis.kafka.entities.Teacher;
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
    KafkaTemplate<String, Object> kafkaTemplate;

    public String sendMessage(Course course){
        kafkaTemplate.send(orderTopic, course);

        log.info("course sent {}", course);

        return "message sent";
    }

    public String sendMessage(Teacher teacher){
        kafkaTemplate.send(orderTopic, teacher);

        log.info("teacher sent {}", teacher);

        return "message sent";
    }
}
