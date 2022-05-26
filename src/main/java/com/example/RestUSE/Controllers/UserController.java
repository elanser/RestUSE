package com.example.RestUSE.Controllers;

import com.example.RestUSE.Entity.TUser;
import com.example.RestUSE.Services.Interfaces.IUSEUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    IUSEUserService userService;

    @Autowired
    public void setInjectedBean(IUSEUserService userService) {
        this.userService = userService;
    }

//    @RequestMapping(value="/invitefriends/updateFBRequest.json", method=RequestMethod.POST)
//    public void updateFBRequest(
//            HttpServletRequest request,
//            @RequestParam(value="appRequestId", required = true) String appRequestId,
//            @RequestParam(value="toProviderIds", required = true) String toProviderIds)
//    {
//        RTVMember member = RequestUtils.getMember(request);
//        StringTokenizer tokenizer = new StringTokenizer(toProviderIds, ",");
//        List<String> toProviderIdsList = new ArrayList<String>();
//        while(tokenizer.hasMoreTokens())
//        {
//            toProviderIdsList.add(tokenizer.nextToken());
//        }
//
//        inviteFriendsService.insertInvitedFriendsRequest(member.getMemberID(), appRequestId, toProviderIdsList);
//    }

    @RequestMapping(value = "/login",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody TUser getUser(@RequestParam("login") String login, @RequestParam("password") String password) {
        return userService.getUserByLoginPassword(login,password);
    }

    @RequestMapping(value = "/id/{id}", produces = "application/json", method = {RequestMethod.GET, RequestMethod.PUT})
    public TUser getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @RequestMapping("/all")
    public List<TUser> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/is/{login}", produces = "application/json", method = {RequestMethod.GET, RequestMethod.PUT})
    public Boolean isUser(@PathVariable String login) {
        return userService.isUser(login);
    }

}
