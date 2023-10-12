package com.metamorphosis.kafka.services;

import com.metamorphosis.kafka.entities.Course;
import com.metamorphosis.kafka.entities.Teacher;
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
    public String sendTeacher(Teacher teacher) {
        return producer.sendMessage(teacher);
    }

    @Override
    public void readCourse(String course) {
        System.out.println(course);
    }

    @Override
    public void readCourse(Course course) {
        System.out.println(course);
    }

    @Override
    public void readTeacher(Teacher teacher) {
        System.out.println(teacher);
    }

}
