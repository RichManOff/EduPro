package com.example.diplomaproject.service;

import com.example.diplomaproject.dto.SpecialtyDto;
import com.example.diplomaproject.model.Specialty;
import com.example.diplomaproject.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    public Specialty saveSpecialty(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    public Specialty getSpecialtyById(Long id) {
        return specialtyRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Specialty not found for this id :: " + id));
    }

    public List<Specialty> getAllSpecialties() {
        return specialtyRepository.findAll();
    }

    public void deleteSpecialtyById(Long id) {
        specialtyRepository.deleteById(id);
    }

    public Specialty updateSpecialty(Specialty updatedSpecialty) {
        Optional<Specialty> existingSpecialtyOptional = specialtyRepository.findById(updatedSpecialty.getId());
        if (existingSpecialtyOptional.isPresent()) {
            Specialty existingSpecialty = existingSpecialtyOptional.get();
            existingSpecialty.setName(updatedSpecialty.getName());
            return specialtyRepository.save(existingSpecialty);
        } else {
            return null; // or throw an exception, depending on the use case
        }
    }

    public List<SpecialtyDto> getSpecialtyDtos(List<Specialty> specialties) {
        List<SpecialtyDto> specialtyDtos = new ArrayList<>();
        for (Specialty specialty : specialties) {
            specialtyDtos.add(new SpecialtyDto(specialty.getId(), specialty.getName()));
        }
        return specialtyDtos;
    }

    public List<Specialty> searchSpecialties(String keyword) {
        return specialtyRepository.searchSpecialties(keyword);
    }

}
