package com.deepraj1729.coursemanagementlogger.repository;

import com.deepraj1729.coursemanagementlogger.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request,Integer> {
}
