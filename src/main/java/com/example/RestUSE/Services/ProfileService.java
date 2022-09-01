package com.example.RestUSE.Services;

import com.example.RestUSE.Entity.Profile;
import com.example.RestUSE.Repositories.Interfaces.ProfileRepository;
import com.example.RestUSE.Services.Interfaces.IProfileService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@Service
public class ProfileService implements IProfileService {
    ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public CompletableFuture<List<Profile>> getProfileList() {
        Supplier profileSupplier = () -> profileRepository.getProfileList().orElse(new ArrayList<>());
        CompletableFuture<List<Profile>> profileList = CompletableFuture.supplyAsync(profileSupplier);
        return profileList;
    }

    @Override
    public CompletableFuture<List<Profile>> getProfileListByIDSection(Long id) {
        Supplier profileSupplier = () -> profileRepository.getProfileListByIDSection(id).orElse(new ArrayList<>());
        CompletableFuture<List<Profile>> profileList = CompletableFuture.supplyAsync(profileSupplier);
        return profileList;
    }

    @Override
    public CompletableFuture<Integer> newProfile(Long idSection, String nameProfile, int numTickets) {
        Supplier profileSupplier = () -> profileRepository.newProfile(idSection,nameProfile,numTickets);
        CompletableFuture<Integer> newProfileCF = CompletableFuture.supplyAsync(profileSupplier);
        return newProfileCF;
    }

    @Override
    public CompletableFuture<Integer> updateProfile(Long id, Long idSection, String nameProfile, int numTickets) {
        Supplier profileSupplier = () -> profileRepository.updateProfile(id,idSection,nameProfile,numTickets);
        CompletableFuture<Integer> saveProfileCF = CompletableFuture.supplyAsync(profileSupplier);
        return saveProfileCF;
    }

    @Override
    public CompletableFuture<Integer> saveProfile(Long id, Long idSection, String nameProfile, int numTickets) {
        CompletableFuture<Integer> saveProfileCF;
        Supplier updateSupplier = () -> profileRepository.updateProfile(id,idSection,nameProfile,numTickets);
        Supplier newSupplier = () -> profileRepository.newProfile(idSection,nameProfile,numTickets);
        if (id>0) {
            saveProfileCF = CompletableFuture.supplyAsync(updateSupplier);
        }
        else {
            saveProfileCF = CompletableFuture.supplyAsync(newSupplier);
        }
        return saveProfileCF;
    }
}
