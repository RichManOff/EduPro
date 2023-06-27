package com.example.diplomaproject.service;

import com.example.diplomaproject.model.Favorite;
import com.example.diplomaproject.repository.FavoriteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;

    public List<Long> findUniversityIdsByUserId(Long userId) {
        List<Long> universityIds = new ArrayList<>(); // Initialize the list

        List<Favorite> favorites = favoriteRepository.findFavoritesByUserId(userId);
        if (favorites.isEmpty()) {
            log.info("Favorites null");
            return universityIds; // Return the empty list
        } else {
            for (int i = 0; i < favorites.size(); i++) {
                universityIds.add(favorites.get(i).getUniversityId());
            }
            log.info("Favorites added");

            return universityIds;
        }
    }


    public void saveFavorites(Long userId, Long universityId){
        Favorite favorite = new Favorite();
        favorite.setUserId(userId);
        favorite.setUniversityId(universityId);
        Favorite checkFavorite = favoriteRepository.findFavoriteByUniversityIdAndUserId(universityId, userId);
        if ( checkFavorite == null){
            favoriteRepository.save(favorite);
        } else {
            log.info("Already added");
        }
    }

    public boolean checkFavorite(Long userId, Long universityId){
        Favorite favorite = favoriteRepository.findFavoriteByUniversityIdAndUserId(universityId, userId);
        if (favorite == null){
            return false;
        }
        return true;
    }
    public void deleteFavorite(Long userId, Long universityId) {
        Favorite favorite = favoriteRepository.findFavoriteByUniversityIdAndUserId(universityId, userId);

        try {
            favoriteRepository.delete(favorite);
        } catch (ObjectOptimisticLockingFailureException ex) {
            // Handle optimistic locking failure
            log.info("Errorrroorooror");
            // You can choose to retry the delete operation or handle it as needed
            // For example, you can log the error, notify the user, or take alternative actions
        }
    }

    public List<Favorite> getFavorites(Long userId){
        return favoriteRepository.findFavoritesByUserId(userId);
    }
}
