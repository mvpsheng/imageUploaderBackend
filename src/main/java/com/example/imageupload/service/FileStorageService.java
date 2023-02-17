package com.example.imageupload.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * FileName: FileStorageService
 * author: gxs
 * Date: 2023/2/17  14:30
 */
public interface FileStorageService {
    public void init();

    public void save(MultipartFile file);

    public Resource load(String filename);

    public boolean delete(String filename);

    public void deleteAll();

    public Stream<Path> loadAll();
}
