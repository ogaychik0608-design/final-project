package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {
    private final String uploadPath = "src/main/resources/static/images/products/";

    public String saveFile(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) return null;

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        String resultFilename = UUID.randomUUID().toString() + "." + file.getOriginalFilename();
        file.transferTo(new File(uploadDir.getAbsolutePath() + "/" + resultFilename));

        return resultFilename;
    }

}