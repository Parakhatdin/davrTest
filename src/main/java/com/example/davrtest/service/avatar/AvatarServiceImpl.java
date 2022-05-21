package com.example.davrtest.service.avatar;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;

@Service
public class AvatarServiceImpl implements AvatarService {
    private final Path root;

    public AvatarServiceImpl(Environment env) {
        this.root = Paths.get(env.getProperty("app.file.avatars-dir", "storage/avatars"));
    }

    @Override
    public String save(MultipartFile image){
        String contentType = image.getContentType();
        if (!isSupportedContentType(contentType))throw new RuntimeException("image must be .png or .jpg");

        try(InputStream inputStream = image.getInputStream()) {
            if (!Files.exists(root)) {
                Files.createDirectories(root);
            }
            String imageName = StringUtils.cleanPath("avatar-" + LocalTime.now() + "-" + image.getOriginalFilename());
            Path imagePath = root.resolve(imageName);
            Files.copy(inputStream, imagePath);
            return ServletUriComponentsBuilder.fromCurrentContextPath().path("/avatars/").path(imageName).toUriString();
        } catch (IOException exception) {
            throw new RuntimeException("image not saved: " ,exception);
        }
    }


    private boolean isSupportedContentType(String contentType) {
        return contentType.equals("image/png") || contentType.equals("image/jpeg");
    }
}
