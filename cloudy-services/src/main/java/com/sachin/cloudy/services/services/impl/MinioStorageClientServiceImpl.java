package com.sachin.cloudy.services.services.impl;

import com.sachin.cloudy.services.exception.CloudyServiceException;
import com.sachin.cloudy.services.services.StorageClientService;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by sachinhooda on 19/12/17.
 */
@Service

public class MinioStorageClientServiceImpl implements StorageClientService {

    private MinioClient minioClient;

    @Autowired
    public MinioStorageClientServiceImpl(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    @Override
    public void upload(String bucket, String name, InputStream stream, long size, String contentType) throws CloudyServiceException {

        try {
            minioClient.putObject(bucket, name, stream, size, contentType);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoResponseException | XmlPullParserException | InvalidBucketNameException | InvalidArgumentException | InsufficientDataException | ErrorResponseException | InternalException | IOException e) {
            throw new CloudyServiceException();
        }
    }

    @Override
    public String getBucketAccessURL(String bucket, String name) throws CloudyServiceException {
        try {
            return minioClient.presignedGetObject(bucket, name);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoResponseException | XmlPullParserException | InvalidBucketNameException | InsufficientDataException | ErrorResponseException | InternalException | InvalidExpiresRangeException | IOException e) {
            throw new CloudyServiceException();
        }
    }
}
