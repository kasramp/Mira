package com.madadipouya.mira.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.tika.Tika;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.madadipouya.mira.entity.File;
import com.madadipouya.mira.repository.FileRepository;
import com.madadipouya.mira.service.FileService;

@Service
public class FileServiceImpl implements FileService {

    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    private static final String EXTENSION_UNKNOWN = ".unknown";

    private final FileRepository fileRepository;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public String storeFile(byte[] fileContent) {
        return fileRepository.save(new File(generateFullyQualifiedFileName(identifyFileExtension(fileContent)), fileContent)).getName();
    }

    private String identifyFileExtension(byte[] fileContent) {
        try {
            return MimeTypes.getDefaultMimeTypes().forName(new Tika().detect(fileContent)).getExtension();
        } catch (MimeTypeException mimeTypeException) {
            logger.warn("Couldn't detect file extension", mimeTypeException);
        }
        return EXTENSION_UNKNOWN;
    }

    private String generateFullyQualifiedFileName(String fileExtension) {
        return RandomStringUtils.randomAlphabetic(10).toUpperCase() + fileExtension;
    }
}
