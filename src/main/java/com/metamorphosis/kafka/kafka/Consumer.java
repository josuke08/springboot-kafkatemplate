package com.metamorphosis.kafka.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.metamorphosis.kafka.entities.Course;
import com.metamorphosis.kafka.services.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    private static final String orderTopic = "${topic.name}";

    @Autowired
    CourseService courseService;

    @KafkaListener(topics = orderTopic, containerFactory = "kafkaListenerContainerFactory")
    public void consumeMessage(Course course){
        log.info("message consumed {}", course);
        courseService.readCourse(course);
    }}
