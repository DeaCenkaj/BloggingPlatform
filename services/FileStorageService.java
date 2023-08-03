package com.dea.codingdojo.blogplatform.services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileStorageService {

    @Value("${file.storage.location}")
    private String fileStorageLocation;

    public String storeFile(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString() + "." + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        File uploadedFile = new File(fileStorageLocation + "/" + fileName);
        file.transferTo(uploadedFile);
        return fileName;
    }

}