///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.groupdocs.conversion;
//
//import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3Client;
//import com.amazonaws.services.s3.model.GetObjectRequest;
//import com.amazonaws.services.s3.model.PutObjectRequest;
//import com.amazonaws.services.s3.model.S3Object;
//import com.groupdocs.conversion.domain.FileDescription;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import org.apache.commons.io.IOUtils;
//
//import javax.naming.NoPermissionException;
//
//
///**
// *
// * @author Alexander
// */
//public class AmazonS3InputDataHandler {
//    private final AmazonS3 s3;
//    private final String bucketName;
//    private final String uploadPath;
//
//    /**
//     * Constructor
//     *
//     * @param accessKey AWS access key
//     * @param secretKey AWS secret key
//     * @param bucketName bucket name
//     */
//    public AmazonS3InputDataHandler(String accessKey, String secretKey, String bucketName) {
//        this(accessKey, secretKey, bucketName, null);
//    }
//
//    /**
//     * Constructor
//     *
//     * @param accessKey AWS access key
//     * @param secretKey AWS secret key
//     * @param bucketName bucket name
//     * @param uploadPath upload path<br>
//     * ex: somefolder/uploads/<br>
//     * pass null or empty String for root directory
//     */
//    public AmazonS3InputDataHandler(String accessKey, String secretKey, String bucketName, String uploadPath) {
//        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
//        s3 = new AmazonS3Client(credentials);
//        this.bucketName = bucketName;
//        if (uploadPath == null) {
//            this.uploadPath = "";
//        } else {
//            if (!uploadPath.endsWith("/")) {
//                uploadPath = uploadPath + "/";
//            }
//            this.uploadPath = uploadPath;
//        }
//    }
//
//    public FileDescription getFileDescription(String guid) throws Exception {
//        S3Object object = s3.getObject(new GetObjectRequest(bucketName, guid));
//        
//        FileDescription fileDescription = new FileDescription();
//        fileDescription.setGuid(guid);
//        fileDescription.setName(object.getKey());
//        fileDescription.setSize(object.getObjectMetadata().getContentLength());
//        fileDescription.setLastModified(object.getObjectMetadata().getLastModified().getTime());
//        return fileDescription;
//    }
//
//    public InputStream getFile(String guid) throws NoPermissionException {
//        S3Object object = s3.getObject(new GetObjectRequest(bucketName, guid));
//        return object.getObjectContent();
//    }
//
//    public String saveFile(InputStream inputStream, String fileName) {
//        String pathFile = "";
//        try {
//            File file = File.createTempFile("temp", "tmp");
//            OutputStream outputStream = new FileOutputStream(file);
//            IOUtils.copy(inputStream, outputStream);
//            s3.putObject(new PutObjectRequest(bucketName, uploadPath + fileName, file));
//            IOUtils.closeQuietly(outputStream);
//            pathFile = uploadPath + fileName;
//            outputStream.flush();
//            outputStream.close();
//        } catch (IOException ex) {
//            System.out.println(ex);
//        }
//        return pathFile;
//    }
//}
