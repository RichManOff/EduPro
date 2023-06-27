package com.example.diplomaproject.service;

import com.example.diplomaproject.model.University;
import com.example.diplomaproject.repository.UniversityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
@Slf4j
@Service
public class UniversityService {

    private final UniversityRepository universityRepository;

    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }


    public List<University> getRandomUniversities() {
        List<University> universities = universityRepository.findAll();
        int totalUniversities = universities.size();
        int count = Math.min(totalUniversities, 10); // Set the desired count of random universities (10 in this case)

        if (count == totalUniversities) {
            return universities; // If the count is equal to the total universities, return all universities
        } else {
            Random random = new Random();
            for (int i = totalUniversities - 1; i >= count; i--) {
                int randomIndex = random.nextInt(i + 1);
                University temp = universities.get(i);
                universities.set(i, universities.get(randomIndex));
                universities.set(randomIndex, temp);
            }
            return universities.subList(0, count); // Return the first 'count' universities
        }
    }


    public List<University> getFirstFourUniversities() {
        return universityRepository.findFirst4ByOrderByIdAsc();
    }

    public University getUniversityById(Long id) {
        return universityRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("University not found for this id :: " + id));
    }

    public List<University> searchUniversitiesByName(String name) {
        return universityRepository.findByNameContainingIgnoreCase(name);
    }

    public List<University> searchUniversitiesByLocation(String location) {
        return universityRepository.findByLocationContainingIgnoreCase(location);
    }

    public List<University> searchUniversities(String keyword) {
        List<University> universities = universityRepository.searchUniversities(keyword);
        log.info(universities + " univ");
        return universities;
    }

    public University createUniversity(University university) {
        return universityRepository.save(university);
    }

    public University updateUniversity(Long id, University university) {
        University existingUniversity = universityRepository.findById(id).orElse(null);
        if (existingUniversity != null) {
            existingUniversity.setName(university.getName());
            existingUniversity.setDescription(university.getDescription());
            existingUniversity.setLocation(university.getLocation());
            existingUniversity.setWebsite(university.getWebsite());
            existingUniversity.setLogo(university.getLogo());
            return universityRepository.save(existingUniversity);
        }
        return null;
    }

    public void deleteUniversity(Long id) {
        universityRepository.deleteById(id);
    }

}