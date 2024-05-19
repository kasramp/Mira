package com.madadipouya.mira.service;

import com.madadipouya.mira.exception.FileNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    String storeFile(MultipartFile file, String baseUrl) throws IOException;

    byte[] downloadFile(String path, String fileName) throws FileNotFoundException;
}
