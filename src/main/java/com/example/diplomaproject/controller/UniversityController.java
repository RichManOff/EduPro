package com.example.diplomaproject.controller;

import com.example.diplomaproject.model.Comment;
import com.example.diplomaproject.model.Specialty;
import com.example.diplomaproject.model.University;
import com.example.diplomaproject.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/home/universities")
public class UniversityController {

    @Autowired
    private UniversityService universityService;


    @Autowired
    private SpecialtyService specialtyService;

    @Autowired
    private UniversitySpecialtyService universitySpecialtyService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private SearchService searchService;

    @Autowired
    private AccountDetailsService accountDetailsService;
    private Long univId;

    @GetMapping
    public ModelAndView universitiesPage(){
        ModelAndView mav = new ModelAndView("Find_univercity");
        return mav;

    }

    @GetMapping("/list")
    public List<University> getUniversities() {
        return universityService.getAllUniversities();
    }

    @GetMapping("/universities/search")
    public ResponseEntity<List<University>> searchUniversities(@RequestParam String keyword) {
        List<University> universities = universityService.searchUniversities(keyword);
        return ResponseEntity.ok(universities);
    }

    @GetMapping("/info")
    public ModelAndView universityInfo(@RequestParam(value = "id") Long id){
        ModelAndView mav = new ModelAndView("IITU");
        univId = id;
        log.info( univId + "///////////////");
        return mav;

    }

    @GetMapping("/info/id")
    public ResponseEntity<University> getUniversityById(Principal principal) {
        University university = universityService.getUniversityById(univId);
        log.info(univId + "    isefaljfbhalfhab ");
        Long userId = accountDetailsService.findByUsername( principal.getName()).getId();

        if (principal != null) {
            searchService.saveUniversities(userId, university.getId());
            return ResponseEntity.ok(university);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/specialties")
    public ResponseEntity<List<Specialty>> getUniversitySpecialties() {
        List<Specialty> specialtyList = specialtyService.getAllSpecialties();
        List<Specialty> specialties = universitySpecialtyService.getSpecialtiesByUniversityId(univId, specialtyList);
        log.info(univId + "    isefaljfbhalfhab " + specialties.toString());
        return ResponseEntity.ok(specialties);
    }

    @PostMapping("/info/submit-comment") // Replace with the actual URL endpoint
    public ResponseEntity<String> submitFeedback(@RequestBody Comment comment, Principal principal) {
        // Process the feedback data
        String commentText = comment.getComment();
        int rating = comment.getRating();
        Long universityId = comment.getUniversityId();
        Long userId = accountDetailsService.findByUsername( principal.getName()).getId();
        commentService.save(commentText,rating,universityId,userId);
        return ResponseEntity.ok("Feedback submitted successfully");
    }



}
