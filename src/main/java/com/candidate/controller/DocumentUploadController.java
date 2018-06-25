package com.candidate.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.candidate.model.FileUploadMetaData;
import com.candidate.model.FileUploadRepository;

/** A rest controller provides api to upload single file as post request and get the uploaded files as an get request*/
@RestController
public class DocumentUploadController {
	private final Logger logger = LoggerFactory.getLogger(DocumentUploadController.class);

	/** Save the uploaded file to this folder */
	private static String UPLOADED_FOLDER = "C:/work/virtusa-doc/upload/";

	/**
	 * This object is required to store file meta data into in memory database
	 */
	@Autowired
	private FileUploadRepository fileUploadMetaData;

	/**
	 * Single file upload
	 * @param uploadfile
	 * @param request
	 * @return
	 */
	@PostMapping(value = "/candidate/fileupload")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadfile,
			final HttpServletRequest request) {

		/** Below data is what we saving into database */
		logger.debug("Single file upload!");
		logger.debug("fileName : " + uploadfile.getOriginalFilename());
		logger.debug("contentType : " + uploadfile.getContentType());
		logger.debug("contentSize : " + uploadfile.getSize());

		if (uploadfile.isEmpty()) {
			return new ResponseEntity<String>("please select a file!", HttpStatus.OK);
		}

		try {
			/** File will get saved to file system and database */
			saveUploadedFiles(Arrays.asList(uploadfile));
		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>("Successfully uploaded - " + uploadfile.getOriginalFilename(),
				new HttpHeaders(), HttpStatus.OK);

	}

	/**
	 * Rest endpoint api to get uploaded files 
	 * @return
	 */
	@GetMapping(value = "/candidate/getFileUploadMetaData")
	public List<FileUploadMetaData> fileUploadMetaData() {
		List<FileUploadMetaData> fileMetaData = fileUploadMetaData.findAll();
		return fileMetaData;
	}

	/**
	 * Rest endpoint api to download file
	 * @return
	 */
	@RequestMapping(value = "/candidate/download/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getDownloadData(@PathVariable String id) throws Exception {

		FileUploadMetaData fileMetaData = fileUploadMetaData.getOne(Integer.valueOf(id));
	    byte[] output = fileMetaData.getFileContent();

	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("charset", "utf-8");
	    responseHeaders.setContentType(MediaType.valueOf("text/html"));
	    responseHeaders.setContentLength(output.length);
		responseHeaders.set("Content-disposition", "attachment; filename=" + fileMetaData.getName());

	    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
	}
	
	/**
	 * Files will get saved to file system and database
	 * @param files
	 * @throws IOException
	 */
	private void saveUploadedFiles(List<MultipartFile> files) throws IOException {
		for (MultipartFile file : files) {
			if (file.isEmpty()) {
				continue; 
			}
//			byte[] bytes = file.getBytes();
//			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//			Files.write(path, bytes);
			saveMetaData(file);

		}

	}

	/**
	 * Saves meta data to database
	 * @param file
	 * @throws IOException
	 */
	private void saveMetaData(MultipartFile file) throws IOException {
		FileUploadMetaData metaData = new FileUploadMetaData();
		metaData.setName(file.getOriginalFilename());
		metaData.setContentType(file.getContentType());
		metaData.setContentSize(file.getSize());
		metaData.setFileContent(file.getBytes());
		fileUploadMetaData.save(metaData);
	}
}
