package com.job_tracker.controller;

import com.job_tracker.dto.UpdatePasswordRequest;
import com.job_tracker.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/password")
    public ResponseEntity<String> updatePassword(@RequestBody UpdatePasswordRequest request) {
        userService.updatePassword(request);
        return ResponseEntity.ok("Password updated successfully");
    }

    @DeleteMapping("/account")
    public ResponseEntity<String> deleteAccount() {
        userService.deleteAccount();
        return ResponseEntity.ok("Account deleted successfully");
    }
}