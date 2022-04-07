package com.deepraj1729.coursemanagementlogger.repository;

import com.deepraj1729.coursemanagementlogger.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
