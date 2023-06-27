package com.example.diplomaproject.service;

import com.example.diplomaproject.model.Specialty;
import com.example.diplomaproject.model.University;
import com.example.diplomaproject.model.UniversitySpecialty;
import com.example.diplomaproject.repository.UniversitySpecialtyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UniversitySpecialtyService {

    @Autowired
    UniversitySpecialtyRepository universitySpecialtyRepository;



    public List<Specialty> getSpecialtiesByUniversityId(Long universityId, List<Specialty> specialtyList){
        List<Specialty> specialties = new ArrayList<>();
        List<UniversitySpecialty> universitySpecialties = universitySpecialtyRepository.findUniversitySpecialtiesByUniversityId(universityId);

        for (UniversitySpecialty universitySpecialty : universitySpecialties) {
            log.info(universitySpecialty.getSpecialtyId() + "");
            specialties.add(specialtyList.get(universitySpecialty.getSpecialtyId().intValue() - 1));
        }
        return specialties;
    }

    public List<University> getUniversityBySpecialtyId(Long specialtyId, List<University> universityList){
        List<University> universities = new ArrayList<>();
        List<UniversitySpecialty> universitySpecialties = universitySpecialtyRepository.findUniversitySpecialtiesBySpecialtyId(specialtyId);
        for (UniversitySpecialty universitySpecialty : universitySpecialties) {
            log.info(universitySpecialty.getUniversityId() + "");
            log.info(universityList.toString());
            universities.add(universityList.get(universitySpecialty.getUniversityId().intValue() - 1));

        }
        return universities;
    }
}
