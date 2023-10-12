package com.metamorphosis.kafka.services;

import com.metamorphosis.kafka.entities.Course;
import com.metamorphosis.kafka.entities.Teacher;

public interface CourseService {
    String sendCourse(Course course);
    String sendTeacher(Teacher teacher);
    void readCourse(String course);
    void readCourse(Course course);
    void readTeacher(Teacher teacher);
}
