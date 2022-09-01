package com.example.RestUSE.Services.Interfaces;


import com.example.RestUSE.Entity.Profile;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IProfileService {
    CompletableFuture<List<Profile>> getProfileList();
    CompletableFuture<List<Profile>> getProfileListByIDSection(Long iDSection);
    CompletableFuture<Integer> newProfile(Long idSection, String nameProfile, int numTickets);
    CompletableFuture<Integer> updateProfile(Long id,Long idSection, String nameProfile, int numTickets);
    CompletableFuture<Integer> saveProfile(Long id,Long idSection, String nameProfile, int numTickets);
}
