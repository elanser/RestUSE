package com.example.RestUSE.Controllers;

import com.example.RestUSE.Entity.Profile;
import com.example.RestUSE.Services.Interfaces.IProfileService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin
@RequestMapping("/profiles")
public class ProfileController {
    IProfileService profileService;

    ProfileController(IProfileService profileService) {
        this.profileService = profileService;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    CompletableFuture<Integer> getUserJPA(@RequestParam("idSection") Long idSection,
                                       @RequestParam("nameProfile") String nameProfile,
                                       @RequestParam("numTickets") int numTickets) throws ExecutionException, InterruptedException {
        return profileService.newProfile(idSection,nameProfile,numTickets);
    }


    @RequestMapping(value = "/section",method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody CompletableFuture<List<Profile>> getProfileList(@RequestParam("ids") Long ids) throws ExecutionException, InterruptedException {
        return profileService.getProfileListByIDSection(ids);
    }

    @RequestMapping(value = "/ids/{id}", produces = "application/json", method = {RequestMethod.GET})
    public CompletableFuture<List<Profile>> getProfileList1(@PathVariable Long id) {
        return profileService.getProfileListByIDSection(id);
    }

    @RequestMapping(value = "/all", produces = "application/json")
    public CompletableFuture<List<Profile>> getProfileListAll() {
        return profileService.getProfileList();
    }

}
