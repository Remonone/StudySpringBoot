package com.Remonone.StudySB.AWS;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AWSConfig {

	@Value("${AWS.Access}")
	private String access_key;
	@Value("${AWS.Secret}")
	private String secret_key;
	@Value("${AWS.Region}")
	private String region;
	@Value("${AWS.Bucket}")
	private String bucket;
	

	@Bean
	public AmazonS3 getAmazonS3Client() {
		final BasicAWSCredentials credentials = new BasicAWSCredentials(access_key,secret_key);
	    AmazonS3 s3client = AmazonS3ClientBuilder
	            .standard()
	            .withCredentials(new AWSStaticCredentialsProvider(credentials))
	            .withRegion(region)
	            .build();
	    return s3client;
	}
}
