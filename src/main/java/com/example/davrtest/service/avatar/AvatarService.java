package com.example.davrtest.service.avatar;

import org.springframework.web.multipart.MultipartFile;

public interface AvatarService {
    public String save(MultipartFile image) throws RuntimeException;
}
