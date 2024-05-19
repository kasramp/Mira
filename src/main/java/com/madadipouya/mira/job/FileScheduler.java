package com.madadipouya.mira.job;

import com.madadipouya.mira.entity.File;
import com.madadipouya.mira.repository.FileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

@Component
public class FileScheduler {

    private static final Logger logger = LoggerFactory.getLogger(FileScheduler.class);

    private final FileRepository fileRepository;

    public FileScheduler(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    // Run every 5 minutes
    @Scheduled(cron = "0 0/1 * * * ?")
    protected void deleteFilesOlderThanOneDay() {
        ZonedDateTime yesterdayDateTime = getYesterdayDateTime();
        logger.info("Start removing files older than: {}", yesterdayDateTime);
        List<File> files = fileRepository.findAllByCreatedOnBefore(yesterdayDateTime);
        files.forEach(fileRepository::delete);
        logger.info("Finished removing files older than: {}. {} files were deleted", yesterdayDateTime, files.size());
    }

    private ZonedDateTime getYesterdayDateTime() {
        return ZonedDateTime.now(ZoneOffset.UTC).minusDays(1);
    }
}
