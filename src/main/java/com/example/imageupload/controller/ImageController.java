package com.example.imageupload.controller;

import com.example.imageupload.service.FileStorageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * FileName: ImageController
 * author: gxs
 * Date: 2023/2/17  14:34
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/upload")
public class ImageController {
    private final FileStorageService fileStorageService;

    @PostMapping
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        String message = "";
        String imageURL = "";

        try {
            imageURL = fileStorageService.save(file);
//            imageURL = file.getResource().getURL().toString();
//            System.out.println(imageURL + " imageURL");
            message = "Uploaded the image successfully: " + file.getOriginalFilename();
            System.out.println(message);
        } catch (Exception e) {
            message = "Could not upload the image: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
        }

        return imageURL;
    }
}
