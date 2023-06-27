package com.example.diplomaproject.controller;

import com.example.diplomaproject.model.User;
import com.example.diplomaproject.service.AccountDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Slf4j
@RestController
@RequestMapping("/home")
public class MainController {
    @Autowired
    private AccountDetailsService userService;

    @GetMapping("")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index-DESKTOP-QMGODCK");
        return modelAndView;
    }
//
//    @GetMapping("/twoButton")
//    public ModelAndView twoButton() {
//        ModelAndView modelAndView = new ModelAndView("TwoButton");
//        return modelAndView;
//    }

    @GetMapping("/aboutUs")
    public ModelAndView aboutUs() {
        ModelAndView modelAndView = new ModelAndView("About_us");
        return modelAndView;
    }

    @GetMapping("/searchResult")
    public ModelAndView searchResult() {
        ModelAndView modelAndView = new ModelAndView("search_result");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("log_reg");
        return modelAndView;
    }

    @PostMapping("/login/register")
    public ResponseEntity<String> signUp(@RequestBody User account) {
        boolean isRegistered = userService.signup(account);

        if (isRegistered) {
            return ResponseEntity.ok("User registered successfully.");
        } else {
            return ResponseEntity.badRequest().body("User registration failed. Username already exists.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        if (user != null) {
            Authentication a = SecurityContextHolder.getContext().getAuthentication();
            log.info(" Authen " + a.getName() + " " + principal);

            return ResponseEntity.ok("Login successful" + user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email or password is not correct");
        }
    }



//    @GetMapping("/registration")
//    public ModelAndView registrationPage(){
//        ModelAndView mav = new ModelAndView("log_reg");
//        return mav;
//    }
}
