package com.example.vinayak.WebApp.Controller;

import com.example.vinayak.WebApp.Model.ApiResponse;
import com.example.vinayak.WebApp.Model.UserModel;
import com.example.vinayak.WebApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUpdate")
    public ApiResponse<UserModel> createUpdate(@RequestBody UserModel userModel){

        return new ApiResponse<>(userService.createOrUpdate(userModel));
    }

    @GetMapping("/find/all")
    public ApiResponse<Collection<UserModel>> findAll(){
        return new ApiResponse<>(userService.findAll());
    }

    @PostMapping("/delete")
    public ApiResponse<String> deleteUser(@RequestParam("id")Integer id){
        userService.deleteUser(id);
        return new ApiResponse<>("Success");
    }

}
