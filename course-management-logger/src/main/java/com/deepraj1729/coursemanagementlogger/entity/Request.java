package com.deepraj1729.coursemanagementlogger.entity;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "req_type", nullable = false)
    private String requestType;

    @Column(name = "time_stamp")
    private LocalDateTime timeStamp;

    public Request() {
    }

    public Request(String requestType, LocalDateTime timeStamp) {
        this.requestType = requestType;
        this.timeStamp = timeStamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
