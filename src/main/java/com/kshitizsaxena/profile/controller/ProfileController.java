package com.kshitizsaxena.profile.controller;

import com.kshitizsaxena.profile.model.Profile;
import com.kshitizsaxena.profile.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/profiles/{userId}")
    public Mono<Profile> getProfileByUserId(@PathVariable String userId) {
        return profileRepository.findByUserId(userId);
    }
}
