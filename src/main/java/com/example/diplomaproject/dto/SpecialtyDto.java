package com.example.diplomaproject.dto;

import com.example.diplomaproject.model.Specialty;

public class SpecialtyDto {
    private Long id;
    private String name;

    public SpecialtyDto() {
    }

    public SpecialtyDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static SpecialtyDto fromEntity(Specialty specialty) {
        SpecialtyDto dto = new SpecialtyDto();
        dto.setId(specialty.getId());
        dto.setName(specialty.getName());
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
