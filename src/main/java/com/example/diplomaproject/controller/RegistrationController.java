package com.example.diplomaproject.controller;

import com.example.diplomaproject.service.AccountDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class RegistrationController {
    @Autowired
    private AccountDetailsService userService;


}
