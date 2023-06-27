package com.example.diplomaproject.controller;

import com.example.diplomaproject.model.Favorite;
import com.example.diplomaproject.model.SearchHistory;
import com.example.diplomaproject.model.SearchUniversity;
import com.example.diplomaproject.model.User;
import com.example.diplomaproject.service.AccountDetailsService;
import com.example.diplomaproject.service.FavoriteService;
import com.example.diplomaproject.service.SearchService;
import com.example.diplomaproject.service.UniversityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/home")
public class UserController {

    @Autowired
    AccountDetailsService accountDetailsService;

    @Autowired
    UniversityService universityService;

    @Autowired
    FavoriteService favoriteService;

    @Autowired
    SearchService searchService;

    @GetMapping("/userPage")
    public String userPage(Principal principal, Model model) {

        User user = accountDetailsService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        List<SearchUniversity> searchUniversities = searchService.findUniversities(user.getId());
        List<SearchHistory> searchHistories = searchService.findHistories(user.getId());
        List<String> universityNames = new ArrayList<>();
        for (int i = 0; i < searchUniversities.size(); i++){
            String universityName = universityService.getUniversityById(searchUniversities.get(i).getUniversityId()).getName();
            if (universityName.length() > 25) {
                universityName = universityName.substring(0, 25) + "...";
            }
            universityNames.add(universityName);
        }
        List<Favorite> favorites = favoriteService.getFavorites(user.getId());

        List<String> favorityNames = new ArrayList<>();
        for (int i = 0; i < favorites.size(); i++){
            String universityName = universityService.getUniversityById(favorites.get(i).getUniversityId()).getName();
            if (universityName.length() > 25) {
                universityName = universityName.substring(0, 25) + "...";
            }
            favorityNames.add(universityName);
        }
        model.addAttribute("favorityNames", favorityNames);

        model.addAttribute("favorities", favorites);
        model.addAttribute("universities", searchUniversities);
        model.addAttribute("keywords", searchHistories);
        model.addAttribute("universityNames", universityNames);

        return "user_page";
    }

//    @GetMapping("/favorites/info")
//    public ResponseEntity<Boolean> checkUserExists(@RequestParam("id") Long id, Principal principal) {
//        boolean exists = favoriteRepository.existsByUniversityIdAndUserId(id, accountDetailsService.findByUsername(principal.getName()).getId());
//        return ResponseEntity.ok(exists);
//    }
    @GetMapping("/favorites/ids")
    public ResponseEntity<List<Long>> getFavoriteUniversities(Principal principal) {
        if (principal == null) {
            log.info("not auth");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Long userId = accountDetailsService.findByUsername(principal.getName()).getId();
        List<Long> favoriteUniversityIds = favoriteService.findUniversityIdsByUserId(userId);
        log.info("////" + favoriteUniversityIds.toString());
        return ResponseEntity.ok(favoriteUniversityIds);
    }

//    @GetMapping("/favorites/delete")
//    public ResponseEntity<String> deleteFavoriteUniversities(@RequestParam("id") Long id, Principal principal) {
//        Long userId = accountDetailsService.findByUsername(principal.getName()).getId();
//        favoriteService.deleteFavorite(userId, id);
//        log.info("////deleted");
//        return ResponseEntity.ok("deleted   ");
//    }

    @PostMapping("/favorites")
    public ResponseEntity<String> addToFavorites(@RequestParam("id") Long id, Principal principal) {
        // Get the authenticated user (you need to implement this based on your authentication mechanism)
        User user = accountDetailsService.findByUsername(principal.getName());
        if (favoriteService.checkFavorite(user.getId(), id)){
            favoriteService.deleteFavorite(user.getId(), id);
            return ResponseEntity.ok("University deleted to favorites");
        }
        favoriteService.saveFavorites(user.getId(),id);
        return ResponseEntity.ok("University added to favorites");
    }

    @GetMapping("/name")
    @ResponseBody
    public String getUserName(Principal principal) {
        if (principal != null) {
            return principal.getName();
        } else {
            return "Anonymous";
        }
    }

}
