package com.deepraj1729.coursemanagementlogger.service.impl;

import com.deepraj1729.coursemanagementlogger.entity.Request;
import com.deepraj1729.coursemanagementlogger.repository.RequestRepository;
import com.deepraj1729.coursemanagementlogger.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Override
    public List<Request> getAllRequest(){
        return requestRepository.findAll();
    }

    @Override
    public Request saveRequest(Request request){
        return requestRepository.save(request);
    }

    @Override
    public Request getRequestById(int id){
        return requestRepository.findById(id).get();
    }

    @Override
    public Request updateRequest(Request request){
        return requestRepository.save(request);
    }

    @Override
    public void deleteRequestById(int id){
        requestRepository.deleteById(id);
    }
}

