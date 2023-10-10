package com.metamorphosis.kafka.services;

import com.metamorphosis.kafka.entities.Course;
import com.metamorphosis.kafka.kafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements  CourseService{
    @Autowired
    Producer producer;

    @Override
    public String sendCourse(Course course) {
        return producer.sendMessage(course);
    }

    @Override
    public void readCourse(String course) {
        System.out.println(course);
    }
}
