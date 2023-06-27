package com.example.diplomaproject.controller;

import com.example.diplomaproject.model.Specialty;
import com.example.diplomaproject.model.University;
import com.example.diplomaproject.service.AccountDetailsService;
import com.example.diplomaproject.service.SearchService;
import com.example.diplomaproject.service.SpecialtyService;
import com.example.diplomaproject.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/home")
public class SearchController {

    @Autowired
    private AccountDetailsService accountDetailsService;

    @Autowired
    private UniversityService universityService;

    @Autowired
    private SpecialtyService specialtyService;

    @Autowired
    private SearchService searchService;

    @GetMapping("/search")
    public String searchUniversities(@RequestParam("keyword") String keyword, Model model, Principal principal) {
        List<University> universities = universityService.searchUniversities(keyword);
        List<Specialty> specialties = specialtyService.searchSpecialties(keyword);
        Long userId = accountDetailsService.findByUsername( principal.getName()).getId();
        searchService.saveKeywords(userId,keyword);
        model.addAttribute("universities", universities);
        model.addAttribute("specialties", specialties);
        model.addAttribute("keyword", keyword);

        return "search_result";
    }


}
