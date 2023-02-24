package com.example.imageupload.service.impl;

import com.example.imageupload.mapper.ImageMapper;
import com.example.imageupload.model.ImageInfo;
import com.example.imageupload.service.FileStorageService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 * FileName: FileStorageServiceImpl
 * author: gxs
 * Date: 2023/2/17  14:30
 */
@Service
@AllArgsConstructor
public class FileStorageServiceImpl implements FileStorageService {

    private ImageMapper imageMapper;

    private final Path root = Paths.get("uploads");
    @Override
    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    private File convertMultiPartToFile(MultipartFile file ) throws IOException {
        File convFile = new File(root+ "\\" + file.getOriginalFilename() );
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write( file.getBytes() );
        fos.close();
        return convFile;
    }
    @Override
    public String save(MultipartFile file, String label) {
        File newfile = null;
        String imageURL;
        try {
            newfile = convertMultiPartToFile(file);
            imageURL = "localhost:8080\\" + newfile;
            imageMapper.addImage(imageURL, "this is a label");
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }
            throw new RuntimeException(e.getMessage());
        }
        return imageURL;
    }

    @Override
    public Resource load(String filename) {
        return null;
    }

    @Override
    public boolean delete(String filename) {
        return false;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ImageInfo> getAllImages() {
        return imageMapper.getAllImages();
    }
    @Override
    public Stream<Path> loadAll() {
        return null;
    }
}
