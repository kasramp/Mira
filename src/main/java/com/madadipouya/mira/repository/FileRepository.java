package com.madadipouya.mira.repository;

import com.madadipouya.mira.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

    Optional<File> findByPath(String path);

    List<File> findAllByCreatedOnBefore(ZonedDateTime zonedDateTime);
}
