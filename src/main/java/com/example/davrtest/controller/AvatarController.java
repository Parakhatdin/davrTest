package com.example.davrtest.controller;

import com.example.davrtest.service.avatar.AvatarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("avatars")
@RestController
public class AvatarController {
    private final AvatarService avatarService;

    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    @PostMapping("")
    ResponseEntity<String> store(@RequestParam("image") MultipartFile image){
        return ResponseEntity.ok().body(avatarService.save(image));
    }

}
