package com.metamorphosis.kafka.kafka;

import com.metamorphosis.kafka.entities.Course;
import com.metamorphosis.kafka.entities.Teacher;
import com.metamorphosis.kafka.services.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@KafkaListener(id="consumer", topics = "classes1")
public class Consumer {

    @Autowired
    CourseService courseService;

    @KafkaHandler
    public void listen(Course course){
        log.info("message consumed {}", course);
        courseService.readCourse(course);
    }

    @KafkaHandler
    public void listen(Teacher teacher){
        log.info("message consumed {}", teacher);
        courseService.readTeacher(teacher);
    }
}
