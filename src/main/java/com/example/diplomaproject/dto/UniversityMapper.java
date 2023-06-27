package com.example.diplomaproject.dto;

import com.example.diplomaproject.model.University;
import com.example.diplomaproject.model.UniversitySpecialty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UniversityMapper {

//    public static UniversityDto toDto(University university) {
//        UniversityDto dto = new UniversityDto();
//        dto.setId(university.getId());
//        dto.setName(university.getName());
//        dto.setAddress(university.getAddress());
//        dto.setPhone(university.getPhone());
//        dto.setEmail(university.getEmail());
//        dto.setWebsite(university.getWebsite());
//
//        List<SpecialtyDto> specialtyDtos = new ArrayList<>();
//        for (UniversitySpecialty us : university.getUniversitySpecialties()) {
//            SpecialtyDto specialtyDto = new SpecialtyDto();
//            specialtyDto.setId(us.getSpecialty().getId());
//            specialtyDto.setName(us.getSpecialty().getName());
//            specialtyDtos.add(specialtyDto);
//        }
//        dto.setSpecialties(specialtyDtos);
//
//        return dto;
//    }
//
//    public static List<UniversityDto> toDtoList(List<University> universities) {
//        List<UniversityDto> dtos = new ArrayList<>();
//        for (University u : universities) {
//            dtos.add(toDto(u));
//        }
//        return dtos;
//    }

}
