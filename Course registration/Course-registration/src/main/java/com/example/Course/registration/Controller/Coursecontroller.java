package com.example.Course.registration.Controller;

import com.example.Course.registration.Model.Course;
import com.example.Course.registration.Model.Registry;
import com.example.Course.registration.Service.Courseservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Coursereg")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class Coursecontroller {
    @Autowired
    private Courseservice cs;
    @GetMapping("/courses")
    public List<Course> avaiablecourse(){
        return cs.getCourses();
    }
    @GetMapping("/courses/enrolled")
    public List<Registry> enrolledstud(){
        return cs.enrolledlist();
    }
    @PostMapping("/courses/register")
    public String enrollcourse(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("coursename") String coursename){
      cs.enrollCourses(name,email,coursename);
      return "Congratulations! "+name+" enrolled Successfully! "+coursename+" using "+email;
    }
}
