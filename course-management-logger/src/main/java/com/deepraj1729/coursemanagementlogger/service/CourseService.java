package com.deepraj1729.coursemanagementlogger.service;

import com.deepraj1729.coursemanagementlogger.entity.Course;
import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course saveCourse(Course course);

    Course getCourseById(int id);

    Course updateCourse(Course course);

    void deleteCourseById(int id);
}
