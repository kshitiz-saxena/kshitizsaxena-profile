package com.kshitizsaxena.profile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "profiles")
@AllArgsConstructor
public class Profile {
    private String userId;
    private String firstName;
    private String lastName;
}
