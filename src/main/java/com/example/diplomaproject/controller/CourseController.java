package com.example.diplomaproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/home/courses")
public class CourseController {

    @GetMapping("")
    public ModelAndView coursesPage(){
        ModelAndView mav = new ModelAndView("Cours");
        return mav;
    }
}
