/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupdocs.conversion;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
//import com.aspose.ms.System.IO.MemoryStream;
//import com.aspose.ms.System.IO.Stream;
//import com.aspose.ms.System.StringExtensions;
import com.groupdocs.conversion.config.ConversionConfig;
import com.groupdocs.conversion.converter.option.ImageSaveOptions;
import com.groupdocs.conversion.domain.CacheFileDescription;
import com.groupdocs.conversion.handler.cache.ICacheDataHandler;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;

/**
 *
 * @author Alexander
 */
public class AmazonCacheDataHandler implements ICacheDataHandler {
    private static String bucketName = ""; //TODO: Put you bucketname here 
    private final ConversionConfig _conversionConfig;
    private final AmazonS3Client _client;

    public AmazonCacheDataHandler(ConversionConfig conversionConfig, String accessKey, String secretKey) {
        _conversionConfig = conversionConfig;
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        _client = new AmazonS3Client(credentials);
    }

    @Override
    public boolean exists(CacheFileDescription cacheFileDescription) {
        if (!_conversionConfig.getUseCache()) {
            return false;
        }
        if (cacheFileDescription == null) {
            System.out.println("CacheFileDescription.Options is not set");
        }
        if (cacheFileDescription.getLastModified() == 0) {
            return false;
        }
        if (!isNullOrEmpty(cacheFileDescription.getGuid())) {
            System.out.println("CacheFileDescription.Options is not set");;
        }
        if (!isNullOrEmpty(_conversionConfig.getStoragePath())) {
            System.out.println("CacheFileDescription.Options is not set");
        }
        String key = getCachePath(_conversionConfig.getCachePath(), cacheFileDescription);      
        S3Object response = _client.getObject(bucketName, key);

        return response.getObjectMetadata().getLastModified().after(Calendar.getInstance().getTime());
    }

    @Override
    public InputStream getInputStream(CacheFileDescription cacheFileDescription) {
        if (cacheFileDescription == null || !isNullOrEmpty(cacheFileDescription.getGuid())
                || cacheFileDescription.getLastModified() == 0) {
            System.out.println("CacheFileDescription.Options is not set");
        }
        String key = getCachePath(_conversionConfig.getCachePath(), cacheFileDescription);
        S3Object response = _client.getObject(bucketName, key);
        return response.getObjectContent();
    }

    @Override
    public OutputStream getOutputSaveStream(CacheFileDescription cacheFileDescription) {
        try {
            if (!_conversionConfig.getUseCache()) {
                return new ByteArrayOutputStream();
            }
            if (cacheFileDescription == null || !isNullOrEmpty(cacheFileDescription.getGuid())) {
                System.out.println("CacheFileDescription.Options is not set");
            }
            String key = getCachePath(_conversionConfig.getCachePath(), cacheFileDescription);
            File file = File.createTempFile("temp", "tmp");
            
            return null; //new PutObjectRequest(bucketName, key, file);
        } catch (Exception ex) {
            System.out.println(ex); 
        }
        return null;
    }

    @Override
    public String getCacheUri(CacheFileDescription cacheFileDescription) {
        return getCachePath(_conversionConfig.getCachePath(), cacheFileDescription);
    }

    private String getCachePath(String path, CacheFileDescription cacheFileDescription) {
        if (cacheFileDescription.getSaveOptions() == null) {
            System.out.println("CacheFileDescription.Options is not set");
        }
        String filePath = "";
        String fileName = "";
        ImageSaveOptions options = (ImageSaveOptions)cacheFileDescription.getSaveOptions();
        if (options != null) {
            if (isNullOrEmpty(options.getCustomName())) {
                if (options.getUseWidthForCustomName()) {
                    fileName = String.format("%s_%s.%s", options.getCustomName(),
                            options.getWidth(),
                            options.getConvertFileType().toString().toLowerCase());
                } else {
                    fileName = String.format("%s.%s", options.getCustomName(),
                            options.getConvertFileType().toString().toLowerCase());
                }
            } else {
                fileName = String.format("%s.%s", cacheFileDescription.getBaseName(),
                        options.getConvertFileType().toString().toLowerCase());
            }
            filePath = String.format("%s\\%s\\%s\\%s", path, cacheFileDescription.getGuid(),
                    options.getPageNumber(), fileName);
        } else {
            fileName = isNullOrEmpty(cacheFileDescription.getSaveOptions().getCustomName())
                    ? String.format("%s.%s", cacheFileDescription.getSaveOptions().getCustomName(), 
                            cacheFileDescription.getSaveOptions().getConvertFileType().toExtension())
                    : String.format("%s.%s", cacheFileDescription.getBaseName(), 
                            cacheFileDescription.getSaveOptions().getConvertFileType().toExtension());
            filePath = String.format("%s%s/%s", path, cacheFileDescription.getGuid(), fileName);
        }
        return filePath;
    }

    @Override
    public InputStream getInputStreamInternal(CacheFileDescription cacheFileDescription) {
        return getInputStream(cacheFileDescription);
    }

    @Override
    public OutputStream getOutputSaveStreamInternal(CacheFileDescription cacheFileDescription) {
        return getOutputSaveStream(cacheFileDescription);
    }
    
    public boolean isNullOrEmpty(String st) {
        return st != null && !st.isEmpty();
    }
}
