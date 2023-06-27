package com.example.diplomaproject.controller;

import com.example.diplomaproject.model.User;
import com.example.diplomaproject.service.AccountDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/home")
public class AdminController {
    @Autowired
    private AccountDetailsService userService;


    @GetMapping("/admin")
    public String admin(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);

        return "adminTableUni";
    }
}
