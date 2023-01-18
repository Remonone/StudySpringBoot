package com.Remonone.StudySB.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class AmazonService {
	
	private static final Logger LOG = LoggerFactory.getLogger(AmazonService.class);
	
	@Autowired
    private AmazonS3 amazonS3;
	
	@Value("${AWS.Bucket}")
	private String bucket;
	
	@Async
	public void putObject(MultipartFile multipartFile) {
		try {
			ObjectMetadata data = new ObjectMetadata();
		    data.setContentType(multipartFile.getContentType());
		    data.setContentLength(multipartFile.getSize());
		    amazonS3.putObject(bucket, "products/images/" + multipartFile.getOriginalFilename(), multipartFile.getInputStream(), data);
		} catch(Exception e) {
			LOG.error("Error {} occurred while uploading file", e.getLocalizedMessage());
		}
	}
}
