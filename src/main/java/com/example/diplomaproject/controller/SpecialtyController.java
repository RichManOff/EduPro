package com.example.diplomaproject.controller;

import com.example.diplomaproject.model.Specialty;
import com.example.diplomaproject.model.University;
import com.example.diplomaproject.service.SpecialtyService;
import com.example.diplomaproject.service.UniversityService;
import com.example.diplomaproject.service.UniversitySpecialtyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/home/specialties")
public class SpecialtyController {

    @Autowired
    private SpecialtyService specialtyService;

    @Autowired
    private UniversityService universityService;

    @Autowired
    private UniversitySpecialtyService universitySpecialtyService;
    private Long specId;

    @GetMapping
    public ModelAndView specialtiesPage(){
        ModelAndView mav = new ModelAndView("Професий");
        return mav;
    }

    @GetMapping("/list")
    public List<Specialty> getSpecialties() {
        return specialtyService.getAllSpecialties();
    }

    @GetMapping("/info")
    public ModelAndView universityInfo(@RequestParam(value = "id") Long id){
        ModelAndView mav = new ModelAndView("Medicine");
        specId = id;
        log.info( specId + "/////////////////");
        return mav;
    }

//    @GetMapping("/{id}")
//    public ModelAndView getSpecialtyById(@PathVariable(value = "id") Long specialtyId) {
//        Specialty specialty = specialtyService.getSpecialtyById(specialtyId);
//
//        ModelAndView mav = new ModelAndView("Medicine");
//        mav.addObject("specialty", specialty);
//
//        return mav;
//    }

    @GetMapping("/universities")
    public ResponseEntity<List<University>> getSpecialtyUniversities() {
        List<University> universityList = universityService.getAllUniversities();
        List<University> universities = universitySpecialtyService.getUniversityBySpecialtyId(specId, universityList);
        log.info(specId + "    isefaljfbhalfhab " + universities.toString());
        return ResponseEntity.ok(universities);
    }

    @GetMapping("/info/id")
    public ResponseEntity<Specialty> getSpecialtyById() {
        Specialty specialty = specialtyService.getSpecialtyById(specId);
        log.info(specId + "    isefaljfbhalfhab ");

        if (specialty != null) {
            return ResponseEntity.ok(specialty);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
