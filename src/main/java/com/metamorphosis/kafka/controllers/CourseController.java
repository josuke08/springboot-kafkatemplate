package com.metamorphosis.kafka.controllers;

import com.metamorphosis.kafka.entities.Course;
import com.metamorphosis.kafka.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
@CrossOrigin("*")
public class CourseController {
    @Autowired
    CourseService courseService;
    static long i;
    @GetMapping
    String sendCourse(){
        Course course = Course.builder().id(i++).name("History").build();
        return courseService.sendCourse(course);
    }
}
