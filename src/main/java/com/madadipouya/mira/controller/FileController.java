package com.madadipouya.mira.controller;

import com.madadipouya.mira.controller.response.FileResponse;
import com.madadipouya.mira.exception.FileNotFoundException;
import com.madadipouya.mira.service.FileService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.madadipouya.mira.util.UrlUtil.getBaseUrl;

@RestController
@RequestMapping()
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public ResponseEntity<FileResponse> uploadFile(@RequestPart("file") MultipartFile file, HttpServletRequest request) throws IOException {
        return ResponseEntity.ok(new FileResponse(fileService.storeFile(file, getBaseUrl(request))));
    }

    @GetMapping("/{path}/{fileName}")
    public @ResponseBody byte[] downloadFile(@PathVariable String path, @PathVariable String fileName) throws FileNotFoundException {
        return fileService.downloadFile(path, fileName);
    }
}
