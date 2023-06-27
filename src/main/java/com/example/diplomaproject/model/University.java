package com.example.diplomaproject.model;

import lombok.AllArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Entity
@Table(name = "universities")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String location;

    private String website;

    private String logo;

    @Column(name = "rating")
    private double rating;

    public University() {

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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
//
//    public List<Account> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<Account> users) {
//        this.users = users;
//    }

    /*
    *     public void addUniversitySpecialty(UniversitySpecialty universitySpecialty) {
        universitySpecialties.add(universitySpecialty);
        universitySpecialty.setUniversity(this);
    }

    public void removeUniversitySpecialty(UniversitySpecialty universitySpecialty) {
        universitySpecialties.remove(universitySpecialty);
        universitySpecialty.setUniversity(null);
    }

    public List<Specialty> getSpecialties() {
        return universitySpecialties.stream()
                .map(UniversitySpecialty::getSpecialty)
                .collect(Collectors.toList());
    }
*/

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", website='" + website + '\'' +
                ", logo='" + logo + '\'' +
                ", rating=" + rating +
                '}';
    }
}
