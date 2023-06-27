package com.example.diplomaproject.dto;

import com.example.diplomaproject.model.User;

import java.util.List;

public class UniversityDto {
    private Long id;
    private String name;
    private String description;
    private String location;
    private String website;
    private String logo;
    private List<SpecialtyDto> specialties;
    private List<User> users;

    public UniversityDto(){}

    public UniversityDto(Long id, String name, String description, String location, String website, String logo, List<SpecialtyDto> specialties, List<User> users) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.website = website;
        this.logo = logo;
        this.specialties = specialties;
        this.users = users;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<SpecialtyDto> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<SpecialtyDto> specialties) {
        this.specialties = specialties;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
// constructors, getters, setters, etc.
}
