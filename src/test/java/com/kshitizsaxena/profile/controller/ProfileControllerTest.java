package com.kshitizsaxena.profile.controller;

import com.kshitizsaxena.profile.model.Profile;
import com.kshitizsaxena.profile.repository.ProfileRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@WebFluxTest(ProfileController.class)
public class ProfileControllerTest {

    @MockBean
    private ProfileRepository profileRepository;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void getProfileByUserIdTest() {
        String kshitizUserId = "kshitiz";
        Profile kshitizProfile = new Profile();
        kshitizProfile.setUserId(kshitizUserId);
        kshitizProfile.setFirstName("Kshitiz");
        kshitizProfile.setLastName("Saxena");

        Mockito.when(profileRepository.findByUserId(kshitizUserId)).thenReturn(Mono.just(kshitizProfile));

        webTestClient.get()
                .uri("/profiles/{userId}", kshitizUserId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Profile.class)
                .isEqualTo(kshitizProfile);
    }
}
