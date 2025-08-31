package com.example.profiles;

import java.lang.module.ModuleDescriptor.Builder;
import java.util.Objects;

/**
 * Assembles profiles with scattered, inconsistent validation.
 */
public class ProfileService {

    // returns a fully built profile but mutates it afterwards (bug-friendly)
    public UserProfile createMinimal(String id, String email) {
        return new UserProfile.Builder(id, email).build();
    }

    public UserProfile updateDisplayName(UserProfile p, String displayName) {
        Objects.requireNonNull(p, "profile");
        
        return new UserProfile.Builder(p.getId(), p.getEmail())
                .phone(p.getPhone())
                .displayName(displayName)
                .address(p.getAddress())
                .marketingOptIn(p.isMarketingOptIn())
                .twitter(p.getTwitter())
                .github(p.getGithub())
                .build();
    }
}
