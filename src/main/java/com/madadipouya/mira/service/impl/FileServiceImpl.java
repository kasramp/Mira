package com.madadipouya.mira.service.impl;

import com.madadipouya.mira.entity.File;
import com.madadipouya.mira.exception.FileNotFoundException;
import com.madadipouya.mira.repository.FileRepository;
import com.madadipouya.mira.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.madadipouya.mira.util.UrlUtil.generateDownloadPath;
import static com.madadipouya.mira.util.UrlUtil.generateFullyQualifiedDownloadUrl;

@Service
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public String storeFile(MultipartFile file, String baseUrl) throws IOException {
        String fileName = file.getOriginalFilename();
        String path = generateDownloadPath(fileName);
        return fileRepository.save(new File(fileName, file.getBytes(), path, generateFullyQualifiedDownloadUrl(baseUrl, path))).getUrl();
    }

    @Override
    public byte[] downloadFile(String path, String fileName) throws FileNotFoundException {
        String fullPath = "/%s/%s".formatted(path, fileName);
        return fileRepository.findByPath(fullPath).map(File::getContent).orElseThrow(() -> new FileNotFoundException("Could not find file: %s".formatted(fullPath)));
    }
}