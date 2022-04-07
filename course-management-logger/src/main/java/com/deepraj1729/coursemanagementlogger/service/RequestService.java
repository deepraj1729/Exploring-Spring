package com.deepraj1729.coursemanagementlogger.service;

import com.deepraj1729.coursemanagementlogger.entity.Request;

import java.util.List;

public interface RequestService {
    List<Request> getAllRequest();

    Request saveRequest(Request request);

    Request getRequestById(int id);

    Request updateRequest(Request request);

    void deleteRequestById(int id);
}
