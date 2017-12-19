package com.sachin.cloudy.services.services;

import com.sachin.cloudy.services.exception.CloudyServiceException;

import java.io.InputStream;

/**
 * Created by sachinhooda on 19/12/17.
 */
public interface StorageClientService {

    void upload(String bucket, String name, InputStream stream, long size, String contentType) throws CloudyServiceException;

    String getBucketAccessURL(String bucket, String name) throws CloudyServiceException;
}
