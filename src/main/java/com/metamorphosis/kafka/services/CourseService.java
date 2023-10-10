package com.metamorphosis.kafka.services;

import com.metamorphosis.kafka.entities.Course;
import org.springframework.stereotype.Service;

public interface CourseService {
    String sendCourse(Course course);

    void readCourse(String course);
    void readCourse(Course course);
}
