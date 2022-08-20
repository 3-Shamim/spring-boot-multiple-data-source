package com.learningstuff.springbootmultipledatasource.controllers;

import com.learningstuff.springbootmultipledatasource.models.primary.User;
import com.learningstuff.springbootmultipledatasource.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim Molla
 * Email: shamim.molla@vivasoftltd.com
 */

@RestController
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "")
    public ResponseEntity<?> users() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.users());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createUser(@RequestBody @Valid User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.create(user));

    }


}
