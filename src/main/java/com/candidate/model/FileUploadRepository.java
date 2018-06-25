package com.candidate.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.candidate.model.FileUploadMetaData;

/**
 * A JPA repository used to perform crud operations on file meta data records in
 * database
 */
public interface FileUploadRepository extends JpaRepository<FileUploadMetaData, Integer> {
}