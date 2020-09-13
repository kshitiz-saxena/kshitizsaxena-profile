package com.kshitizsaxena.profile.repository;

import com.kshitizsaxena.profile.model.Profile;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ProfileRepository extends ReactiveMongoRepository<Profile, String> {
    @Query("{'userId':?0}")
    Mono<Profile> findByUserId(String userId);
}
