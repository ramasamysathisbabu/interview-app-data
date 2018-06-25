package com.candidate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** An entity that stores file meta data into database*/
@Entity
@Table(name = "file_upload_meta_data")
public class FileUploadMetaData {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "content_type")
	private String contentType;
	
	@Column(name = "content_size")
	private long contentSize;
	
	@Column(name = "file_content")
	private byte[] fileContent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public long getContentSize() {
		return contentSize;
	}

	public void setContentSize(long contentSize) {
		this.contentSize = contentSize;
	}

	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}
	
}
