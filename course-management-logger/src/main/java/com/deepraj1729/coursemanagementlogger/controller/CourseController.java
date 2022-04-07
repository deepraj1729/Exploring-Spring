package com.deepraj1729.coursemanagementlogger.controller;

import java.time.LocalDateTime;
import com.deepraj1729.coursemanagementlogger.entity.Course;
import com.deepraj1729.coursemanagementlogger.entity.Request;
import com.deepraj1729.coursemanagementlogger.service.CourseService;
import com.deepraj1729.coursemanagementlogger.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private RequestService requestService;


    // GET: /courses (returns a list of courses)
    @GetMapping("/courses")
    public String home(Model model) {
        List<Course> coursesList = courseService.getAllCourses();
        int totalCourses = courseService.getAllCourses().size();

        //Logging
        String requestType = "GET /courses";
        LocalDateTime timeStamp = LocalDateTime.now();
        Request newReq = new Request();
        newReq.setRequestType(requestType);
        newReq.setTimeStamp(timeStamp);
        requestService.saveRequest(newReq);

        model.addAttribute("courseList", coursesList);
        model.addAttribute("totalCourses", totalCourses);
        return "home";
    }

    // GET: /courses/{id} {returns a particular course by id)
    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable("id") int courseID){

        //Logging
        String requestType = "GET /courses/"+courseID;
        LocalDateTime timeStamp = LocalDateTime.now();
        Request newReq = new Request();
        newReq.setRequestType(requestType);
        newReq.setTimeStamp(timeStamp);
        requestService.saveRequest(newReq);
        return courseService.getCourseById(courseID);
    }

    @GetMapping("/courses/create")
    public String createCoursePage(Model model){
        Course course = new Course();
        model.addAttribute("course",course);
        return "create_course";
    }

    //POST: /courses {Creates a new Course returns httpResponse}
    @PostMapping("/courses")
    public String createCourse(@ModelAttribute("course") Course course){

        //Logging
        String requestType = "POST /courses/";
        LocalDateTime timeStamp = LocalDateTime.now();
        Request newReq = new Request();
        newReq.setRequestType(requestType);
        newReq.setTimeStamp(timeStamp);
        requestService.saveRequest(newReq);
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    //PUT: /course/{id} {Updates an existing course)
    @PutMapping("/courses/{id}")
    public void updateCourse(@PathVariable int courseID,@RequestBody Course updatedCourse){
        Course course = courseService.getCourseById(courseID);
        course.setName(updatedCourse.getName());
        course.setAuthor(updatedCourse.getAuthor());

        //Logging
        String requestType = "PUT /courses/"+courseID;
        LocalDateTime timeStamp = LocalDateTime.now();
        Request newReq = new Request();
        newReq.setRequestType(requestType);
        newReq.setTimeStamp(timeStamp);
        requestService.saveRequest(newReq);

    }

    //DELETE
    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable int id){

        //Logging
        String requestType = "DELETE /courses/"+id;
        LocalDateTime timeStamp = LocalDateTime.now();
        Request newReq = new Request();
        newReq.setRequestType(requestType);
        newReq.setTimeStamp(timeStamp);
        requestService.saveRequest(newReq);

        courseService.deleteCourseById(id);
    }

    //GET /logging
    @GetMapping("/logging")
    public List<Request> getAllRequestLogs(){
        return requestService.getAllRequest();
    }

}
