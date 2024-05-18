package com.madadipouya.mira.controller;

import java.io.IOException;
import java.nio.file.Files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.madadipouya.mira.service.FileService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/upload")
public class UploadController {

    private final FileService fileService;

    public UploadController(FileService fileService) {
        this.fileService = fileService;
    }

    @PutMapping
    public ResponseEntity<String> uploadFile(HttpServletRequest request) throws IOException {
        return ResponseEntity.ok(fileService.storeFile(request.getInputStream().readAllBytes()));
    }
}
