package com.deepraj1729.coursemanagementlogger.service.impl;

import com.deepraj1729.coursemanagementlogger.entity.Course;
import com.deepraj1729.coursemanagementlogger.repository.CourseRepository;
import com.deepraj1729.coursemanagementlogger.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    @Override
    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(int id){
        return courseRepository.findById(id).get();
    }

    @Override
    public Course updateCourse(Course course){
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourseById(int id){
        courseRepository.deleteById(id);
    }
}
