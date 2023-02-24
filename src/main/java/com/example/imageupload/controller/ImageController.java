package com.example.imageupload.controller;

import com.example.imageupload.model.ImageInfo;
import com.example.imageupload.service.FileStorageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

/**
 *  功能： 将图片保存到服务器端， 图片的url和label保存到数据库，返回给客户端url，
 *
 * */
    @PostMapping
    public String uploadImage(@RequestParam("file") MultipartFile file, String label) {
        String message = "";
        String imageURL = "";

        try {
            imageURL = fileStorageService.save(file, label);
            System.out.println(imageURL + " image url");
            message = "Uploaded the image successfully: " + file.getOriginalFilename();
            System.out.println(message);
        } catch (Exception e) {
            message = "Could not upload the image: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
        }

        return imageURL;
    }

    @GetMapping
    public List<ImageInfo> getAllImages() {
        return fileStorageService.getAllImages();
    }
}
