package com.madadipouya.mira.controller;

import com.madadipouya.mira.controller.response.FileResponse;
import com.madadipouya.mira.service.FileService;
import com.madadipouya.mira.util.UrlUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.madadipouya.mira.util.UrlUtil.getBaseUrl;

@RestController
@RequestMapping()
public class UploadController {

    private final FileService fileService;

    public UploadController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public ResponseEntity<FileResponse> uploadFile(@RequestPart("file") MultipartFile file, HttpServletRequest request) throws IOException {
        return ResponseEntity.ok(new FileResponse(fileService.storeFile(file, getBaseUrl(request))));
    }
}
