///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.groupdocs.conversion;
//
//import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.services.s3.AmazonS3Client;
//import com.amazonaws.services.s3.model.GetObjectRequest;
//import com.amazonaws.services.s3.model.S3Object;
////import com.aspose.ms.System.IO.MemoryStream;
////import com.aspose.ms.System.IO.Stream;
//import com.groupdocs.conversion.domain.FileDescription;
//import com.groupdocs.conversion.handler.input.IInputDataHandler;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.InputStream;
//
///**
// *
// * @author Alexander
// */
//public class AmazonInputDataHandler implements IInputDataHandler {
//
//    private static String bucketName = ""; //TODO: Put you bucketname here 
//    private AmazonS3Client _client;
//
//    public AmazonInputDataHandler(String accessKey, String secretKey) {
//        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
//        _client = new AmazonS3Client(credentials);
//    }
//
//    @Override
//    public FileDescription getFileDescription(String guid) {
//        FileDescription result = new FileDescription();
//        GetObjectRequest request = new GetObjectRequest(bucketName, guid);
//
//        String fileName;
//        long size;
//        S3Object response = _client.getObject(request);
//
//        fileName = response.getKey();
//        size = response.getObjectMetadata().getContentLength();
//
//        result.setGuid(guid);
//        result.setName(fileName);
//        result.setSize(size);
//        return result;
//    }
//
//    @Override
//    public InputStream getFile(String guid) {
//        GetObjectRequest request = new GetObjectRequest(bucketName, guid);
//        
//        ByteArrayOutputStream result = new ByteArrayOutputStream();
//        S3Object response = _client.getObject(request);
//
//        byte[] buffer = new byte[16384]; //16*1024
//        int read;
//        try {
//            while ((read = response.getObjectContent().read(buffer, 0, buffer.length)) > 0) {
//                result. write(buffer, 0, read);
//            }
//        } catch (Exception ex) {
//            System.out.println(ex); 
//        }
//
//        return new ByteArrayInputStream(result.toByteArray());
//    }
//
//    @Override
//    public InputStream getFileInternal(String guid) {    
//        return getFile(guid);
//    }
//}