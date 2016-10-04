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
//import com.aspose.ms.System.IO.Stream;
//import com.aspose.ms.System.StringExtensions;
import com.groupdocs.conversion.config.ConversionConfig;
import com.groupdocs.conversion.converter.option.ImageSaveOptions;
import com.groupdocs.conversion.converter.option.SaveOptions;
import com.groupdocs.conversion.domain.FileDescription;
import com.groupdocs.conversion.handler.output.IOutputDataHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Alexander
 */
public class AmazonOutputDataHandler implements IOutputDataHandler {
    private static String bucketName = ""; //TODO: Put you bucketname here
    private final ConversionConfig _conversionConfig;
    private final AmazonS3Client _client;

    public AmazonOutputDataHandler(ConversionConfig conversionConfig, String accessKey, String secretKey) {
        _conversionConfig = conversionConfig;
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        _client = new AmazonS3Client(credentials);
    }
    
    @Override
    public String saveFile(FileDescription fileDescription, InputStream stream, SaveOptions saveOptions) {
        String fileName = "";
        try {
            fileName = getOutputPath(fileDescription, saveOptions);
            File file = File.createTempFile("temp", "tmp");
            OutputStream outputStream = new FileOutputStream(file);
            IOUtils.copy(stream, outputStream);
            _client.putObject(new PutObjectRequest(bucketName, fileName, file));
            IOUtils.closeQuietly(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return fileName;
    }

    private String getOutputPath(FileDescription fileDescription, SaveOptions saveOptions) {
        String filePath = "";
        String fileName = "";
        ImageSaveOptions options = (ImageSaveOptions)saveOptions;
        if (options != null) {
            fileName = !isNullOrEmpty(options.getCustomName())
                ? (options.getUseWidthForCustomName()
                    ? String.format("%s_%s_%s.%s", options.getCustomName(),
                        options.getPageNumber(),
                        options.getWidth(),
                        options.getConvertFileType().toString().toLowerCase())
                    : String.format("%s_%s.%s", options.getCustomName(),
                        options.getPageNumber(),
                        options.getConvertFileType().toString().toLowerCase()))
                : String.format("%s_%s.%s", fileDescription.getBaseName(),
                    options.getPageNumber(),
                    options.getConvertFileType().toString().toLowerCase());
            filePath = String.format("%s\\%s", _conversionConfig.getOutputPath(), fileName);
        } else {            
            fileName = !isNullOrEmpty(saveOptions.getCustomName())
                ? String.format("%s.%s", saveOptions.getCustomName(), saveOptions.getConvertFileType().toExtension())
                : String.format("%s.%s", fileDescription.getBaseName(), saveOptions.getConvertFileType().toExtension());
            filePath = String.format("%s\\%s", _conversionConfig.getOutputPath(), fileName);
        }
        return filePath;
    }

    @Override
    public String saveFileInternal(FileDescription fileDescription, InputStream stream, SaveOptions saveOptions) {
        return saveFile(fileDescription, stream, saveOptions);
    }
    
    public boolean isNullOrEmpty(String st) {
        return st != null && !st.isEmpty();
    }
}
