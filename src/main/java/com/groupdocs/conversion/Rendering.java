/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupdocs.conversion;

//import com.aspose.imaging.imageoptions.PsdOptions;
//import com.aspose.imaging.system.io.FileStream;
//import com.aspose.ms.System.Collections.Generic.IGenericList;
//import com.aspose.ms.System.Collections.Generic.List;
//import com.aspose.ms.System.IO.FileAccess;
//import com.aspose.ms.System.IO.FileMode;
//import com.aspose.ms.System.IO.FileStream;
//import com.aspose.ms.System.IO.Path;
//import com.aspose.ms.System.IO.Stream;
import com.groupdocs.conversion.config.ConversionConfig;
import com.groupdocs.conversion.converter.option.HtmlSaveOptions;
import com.groupdocs.conversion.converter.option.ImageSaveOptions;
import com.groupdocs.conversion.converter.option.LoadOptions;
import com.groupdocs.conversion.converter.option.OutputType;
import com.groupdocs.conversion.converter.option.SaveOptions;
import com.groupdocs.conversion.converter.option.SlidesSaveOptions;
import com.groupdocs.conversion.handler.ConversionHandler;
import com.groupdocs.foundation.domain.FileType;
import com.groupdocs.foundation.utils.wrapper.stream.GroupDocsInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
//import com.groupdocs.foundation.domain.FileType;

/**
 *
 * @author Alexander
 */
public class Rendering {
   
    /**
     * <p>
     * Converts and Render file to a HTML format and get output as file path
     * </p>
     */    
    public static void renderHTMLAsPath() throws IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // Convert and save converted HTML documents.
        // Returns paths to the converted HTML documents.
        HtmlSaveOptions saveOptions = new HtmlSaveOptions();
        saveOptions.setCustomName("cache");
        saveOptions.setPageNumber(2);
        saveOptions.setNumPagesToConvert(2);
        saveOptions.setUsePdf_HtmlSaveOptions_New(true);
        saveOptions.setOutputType(OutputType.String);
        
        HtmlSaveOptions saveOptionsConv = new HtmlSaveOptions();
        saveOptionsConv.setOutputType(OutputType.String);

        String convertedDocumentPath = conversionHandler.<String>convert(Common.INPUT_GUID_FILE, saveOptionsConv);
    }

    /**
     * <p>
     * Converts and Render Document as HTML format and outputs the resulting file to a stream
     * </p>
     */
    public static void renderHTMLAsStream() throws IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // Convert and save converted HTML documents. 
        // Returns the converted HTML documents as IO Stream.
        GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream>convert(Common.INPUT_GUID_FILE, new HtmlSaveOptions());
    }

    /**
     * <p>
     * In advance options example Converts and Render Password Protected file to HTML format
     * </p>
     */
    public static void renderHTMLAdvanceOptions() throws IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        //Set password to unprotect protected document during loading
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword("secret");

        // convert starting from page 2 and convert 2 pages
        SaveOptions saveOptions = new HtmlSaveOptions();
        saveOptions.setPageNumber(2);
        saveOptions.setNumPagesToConvert(2);

        // Unprotect input document, Convert and save HTML documents using advance options.
        // Returns the converted HTML documents as IO Stream.
        GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream>convert(Common.INPUT_GUID_FILE, loadOptions, saveOptions);
    }

    /**
     * <p>
     * Converts and Render streamed document into a HTML formated file and get output as file path
     * </p>
     */
    public static void renderToHTMLFromStreamToFile() throws IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // Convert and save converted HTML documents.
        // Returns paths to the converted HTML documents.
        HtmlSaveOptions saveOptions = new HtmlSaveOptions();
        saveOptions.setCustomName(Common.INPUT_GUID_FILE);
        saveOptions.setPageNumber(2);
        saveOptions.setNumPagesToConvert(2);
        saveOptions.setUsePdf_HtmlSaveOptions_New(true);
        saveOptions.setOutputType(OutputType.String);

        // read input document as a stream
        FileInputStream fileStream = new FileInputStream(Paths.get(Common.STORAGE_PATH, Common.INPUT_GUID_FILE).toString());

        SaveOptions saveOptionsNew = new HtmlSaveOptions();
        saveOptionsNew.setOutputType(OutputType.String);
        saveOptionsNew.setCustomName(FilenameUtils.removeExtension(Common.INPUT_GUID_FILE));
         
        String convertedDocumentStream = conversionHandler.<String>convert(fileStream, Common.INPUT_GUID_FILE, saveOptionsNew);

        fileStream.close();
    }

    /**
     * <p>
     * Converts and Render streamed document into a HTML formated file and get output as stream
     * </p>
     */
    public static void renderToHTMLFromStreamToStream() throws FileNotFoundException, IOException {
        //ExStart:RenderToHTMLFromStreamToStream
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // Convert and save converted HTML documents. 
        // Returns the converted HTML documents as IO Stream.
        // read input document as a stream
        FileInputStream fileStream = new FileInputStream(Paths.get(Common.STORAGE_PATH, Common.INPUT_GUID_FILE).toString());

        GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream>convert(fileStream, Common.INPUT_GUID_FILE, new HtmlSaveOptions());

        fileStream.close();
    }


    /**
     * <p>
     * Converts and Render file to an Image format and get output as file path
     * </p>
     * @param outputFileType 
     */
    public static void renderImageAsPath(FileType outputFileType) throws IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // Convert and save converted image file.
        // Returns paths to the converted image file.
        SaveOptions saveOptions = new ImageSaveOptions();
        saveOptions.setConvertFileType(outputFileType);
        saveOptions.setOutputType(OutputType.String);

        List<String> convertedDocumentPath = conversionHandler.<List<String>>convert(Common.INPUT_GUID_FILE, saveOptions);
    }

    /**
     * <p>
     * Converts and Render Document as Image format and outputs the resulting file to a stream
     * </p>
     * @param outputFileType 
     */
    public static void renderImageAsStream(FileType outputFileType) throws IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // Convert and save converted image file. 
        // Returns the converted image file as IO Stream.
        
        ImageSaveOptions saveOptions = new ImageSaveOptions();
        saveOptions.setConvertFileType(outputFileType);
        List<GroupDocsInputStream> convertedDocumentStream = conversionHandler.<List<GroupDocsInputStream>>convert(Common.INPUT_GUID_FILE, saveOptions);
    }

    /**
     * <p>
     * In advance options example Converts and Render Password Protected file to Image format
     * </p>
     * @param outputFileType 
     */
    public static void renderImageAdvanceOptions(FileType outputFileType) throws IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        //Set password to unprotect protected document during loading
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword("secret");

        // convert file to Tiff, starting from page 2 and convert 2 pages,
        // use DPI 300, image width 1024, image height 768
        ImageSaveOptions saveOptions = new ImageSaveOptions();
        saveOptions.setConvertFileType(outputFileType);
        saveOptions.setPageNumber(2);
        saveOptions.setNumPagesToConvert(2);
        saveOptions.setDpi(300);
        saveOptions.setWidth(1024);
        saveOptions.setHeight(768);

        // Unprotect input document, Convert and save image file using advance options.
        // Returns the converted image file as IO Stream.
        List<GroupDocsInputStream> convertedDocumentStream = conversionHandler.<List<GroupDocsInputStream>>convert(Common.INPUT_GUID_FILE, loadOptions, saveOptions);
    }

    /**
     * <p>
     * Converts and Render streamed file to an Image format and get output as file path
     * </p>
     * @param outputFileType 
     */
    public static void renderToImageFromStreamToFile(FileType outputFileType) throws FileNotFoundException, IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // Convert and save converted image file.
        // Returns paths to the converted image file.
        SaveOptions saveOptions = new ImageSaveOptions();
        saveOptions.setConvertFileType(ImageSaveOptions.ImageFileType.Jpeg);
        saveOptions.setOutputType(OutputType.String);

        // read input document as a stream
        FileInputStream fileStream = new FileInputStream(Paths.get(Common.STORAGE_PATH, Common.INPUT_GUID_FILE).toString());
        
        
        SaveOptions saveOptionsConv = new ImageSaveOptions();
        saveOptionsConv.setOutputType(OutputType.String);
        saveOptionsConv.setCustomName(FilenameUtils.removeExtension(Common.INPUT_GUID_FILE));

        List<String> convertedDocumentStream = conversionHandler.<List<String>>convert(fileStream, Common.INPUT_GUID_FILE, saveOptionsConv);

        fileStream.close();
    }

    /**
     * <p>
     * Converts and Render streamed Document as Image format and outputs the resulting file to a stream
     * </p>
     * @param outputFileType 
     */
    public static void renderToImageFromStreamToStream(FileType outputFileType) throws FileNotFoundException, IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // Returns the converted image file as IO Stream.
        // read input document as a stream
        FileInputStream fileStream = new FileInputStream(Paths.get(Common.STORAGE_PATH, Common.INPUT_GUID_FILE).toString());

        SaveOptions saveOptions = new ImageSaveOptions();
        saveOptions.setConvertFileType(outputFileType);
        
        List<GroupDocsInputStream> convertedDocumentStream = conversionHandler.<List<GroupDocsInputStream>>convert(fileStream, Common.INPUT_GUID_FILE, saveOptions);

        fileStream.close();
    }
    
}
