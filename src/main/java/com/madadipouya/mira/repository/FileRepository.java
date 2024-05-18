package com.madadipouya.mira.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.madadipouya.mira.entity.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}
