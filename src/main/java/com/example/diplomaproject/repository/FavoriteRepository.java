package com.example.diplomaproject.repository;

import com.example.diplomaproject.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
//    @Query("SELECT f.university.id FROM Favorite f WHERE f.user.id = :userId")
//    List<Long> findUniversityIdsByUserId(@Param("userId") Long userId);

    List<Favorite> findFavoritesByUserId(Long userId);
    @Query("SELECT f.universityId FROM Favorite f WHERE f.userId = :userId")
    List<Long> findFavoriteUniversityIdsByUserId(@Param("userId") Long userId);
    boolean existsByUniversityIdAndUserId(Long universityId, Long userId);
    Favorite findFavoriteByUniversityIdAndUserId(Long universityId, Long userId);
//    List<Favorite> findFavoritesByUserId (Long userId);
}
