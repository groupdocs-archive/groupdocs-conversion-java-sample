/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupdocs.conversion;

//import com.aspose.ms.System.Collections.Generic.IGenericList;
//import com.aspose.ms.System.Console;
//import com.aspose.ms.System.IO.FileAccess;
//import com.aspose.ms.System.IO.FileMode;
//import com.aspose.ms.System.IO.FileStream;
//import com.aspose.ms.System.IO.Path;
//import com.aspose.ms.System.IO.Stream;
//import com.aspose.ms.System.StringExtensions;
import com.groupdocs.conversion.config.ConversionConfig;
import com.groupdocs.conversion.converter.option.CellsSaveOptions;
import com.groupdocs.conversion.converter.option.LoadOptions;
import com.groupdocs.conversion.converter.option.OutputType;
import static com.groupdocs.conversion.converter.option.OutputType.Stream;
import com.groupdocs.conversion.converter.option.PdfSaveOptions;
import com.groupdocs.conversion.converter.option.SaveOptions;
import com.groupdocs.conversion.converter.option.SlidesSaveOptions;
import com.groupdocs.conversion.converter.option.WordsSaveOptions;
import com.groupdocs.conversion.handler.ConversionHandler;
import com.groupdocs.conversion.handler.cache.ICacheDataHandler;
import com.groupdocs.conversion.handler.input.IInputDataHandler;
import com.groupdocs.conversion.handler.output.IOutputDataHandler;
import com.groupdocs.foundation.domain.FileType;
import com.groupdocs.foundation.utils.wrapper.stream.GroupDocsInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Alexander
 */
public class Conversion {

    //public static String INPUT_GUID_FILE = "DOCXsample.docx";

    /**
     * <p>
     * Convert file Spreadsheet Document formats and get output as file path
     * </p>
     */
    public static void convertToSpreadsheetAsPath() throws IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // Convert and save converted spreadsheet documents.
        // Returns paths to the converted spreadsheet documents.
        SaveOptions saveOptions = new CellsSaveOptions();
        saveOptions.setOutputType(OutputType.String);

        String convertedDocumentPath = conversionHandler.<String>convert(Common.INPUT_GUID_FILE, saveOptions);
    }

    /**
     * <p>
     * Converts documents to Spreadsheet Document formats and outputs the
     * resulting document to a stream
     * </p>
     */
    public static void convertToSpreadsheetStream() throws IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // Convert and save converted spreadsheet documents. 
        // Returns the converted spreadsheet documents as IO Stream.
        GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream>convert(Common.INPUT_GUID_FILE, new CellsSaveOptions());
    }

    /**
     * <p>
     * In advance options example Convert Password Protected file to Spreadsheet
     * Document formats
     * </p>
     */
    public static void convertToSpreadsheetAdvanceOptions() throws IOException {
        //ExStart:ConvertToSpreadsheetAdvanceOptions
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        //Set password to unprotect protected document during loading
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword("secret");
        // convert file to Xls, starting from page 2 and convert 2 pages
        SaveOptions saveOptions = new CellsSaveOptions();
        saveOptions.setConvertFileType(CellsSaveOptions.CellsFileType.Xls);
        saveOptions.setPageNumber(2);
        saveOptions.setNumPagesToConvert(2);

        // Unprotect input document, Convert and save spreadsheet documents using advance options.
        // Returns the converted spreadsheet documents as IO Stream.
        GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream>convert(Common.INPUT_GUID_FILE, loadOptions, saveOptions);
    }

    /**
     * <p>
     * Converts stream input documents to Spreadsheet Document formats and
     * outputs the resulting document to a file path
     * </p>
     * @throws java.io.FileNotFoundException
     */
    public static void convertToSpreadsheetFromStreamToFile() throws FileNotFoundException, IOException {
        //ExStart:ConvertToSpreadsheetFromStreamToFile
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // read input document as a stream
        //FileStream fileStream = new FileStream(Path.combine(Common.STORAGE_PATH, Common.INPUT_GUID_FILE), FileMode.Open, FileAccess.Read);
        FileInputStream fileStream = new FileInputStream(Paths.get(Common.STORAGE_PATH, Common.INPUT_GUID_FILE).toString());

        CellsSaveOptions saveOptions = new CellsSaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setCustomName(FilenameUtils.removeExtension(Common.INPUT_GUID_FILE));

        
        // Returns the converted spreadsheet documents as File Path using stream input.
        String convertedDocumentStream = conversionHandler.<String>convert(fileStream, Common.INPUT_GUID_FILE, saveOptions);

        fileStream.close();
    }

    /**
     * <p>
     * Converts stream input documents to Spreadsheet Document formats and
     * outputs the resulting document to a stream
     * </p>
     * @throws java.io.IOException
     */
    public static void convertToSpreadsheetFromStreamToStream() throws IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // read input document as a stream
        //FileStream fileStream = new FileStream(Path.combine(Common.STORAGE_PATH, Common.INPUT_GUID_FILE), FileMode.Open, FileAccess.Read);
        FileInputStream fileStream = new FileInputStream(Paths.get(Common.STORAGE_PATH, Common.INPUT_GUID_FILE).toString());

        // Returns the converted spreadsheet documents as IO Stream using stream input.
        GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream>convert(fileStream, Common.INPUT_GUID_FILE, new CellsSaveOptions());
        fileStream.close();
    }

    /**
     * <p>
     * Convert file to Word Processing Document format and get output as file
     * path
     * </p>
     */
    public static void convertToWordDocumentAsPath() throws IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // Convert and save converted word processing documents.
        // Returns paths to the converted word processing documents.
        SaveOptions saveOptions = new WordsSaveOptions();
        saveOptions.setOutputType(OutputType.String);

        String convertedDocumentPath = conversionHandler.<String>convert("PDFsample.pdf", saveOptions);
    }

    /**
     * <p>
     * Converts documents to Word Processing Document formats and outputs the
     * resulting document to a stream
     * </p>
     */
    public static void convertToWordDocumentAsStream() throws IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // Convert and save converted word processing documents. 
        // Returns the converted word processing documents as IO Stream.
        GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream>convert(Common.INPUT_GUID_FILE, new WordsSaveOptions());
    }

    /**
     * <p>
     * In advance options example Convert Password Protected file to Word
     * Processing Document format
     * </p>
     */
    public static void convertToWordDocumentAdvanceOptions() throws IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        //Set password to unprotect protected document during loading
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword("secret");
        // convert file to Doc, starting from page 2 and convert 2 pages,
        SaveOptions saveOptions = new WordsSaveOptions();
        saveOptions.setConvertFileType(WordsSaveOptions.WordsFileType.Doc);
        saveOptions.setPageNumber(2);
        saveOptions.setNumPagesToConvert(2);

        // Unprotect input document, Convert and save word processing documents using advance options.
        // Returns the converted word processing documents as IO Stream.
        GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream>convert(Common.INPUT_GUID_FILE, loadOptions, saveOptions);
    }

    /**
     * <p>
     * Converts stream input documents to Word Processing Document formats and
     * outputs the resulting document to a file path
     * </p>
     */
    public static void convertToWordFromStreamToFile() throws FileNotFoundException, IOException {       
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // read input document as a stream
        FileInputStream fileStream = new FileInputStream(Paths.get(Common.STORAGE_PATH, Common.INPUT_GUID_FILE).toString());

        WordsSaveOptions saveOptions = new WordsSaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setCustomName(FilenameUtils.removeExtension(Common.INPUT_GUID_FILE));

        // Returns the converted Word Processing Documents as File Path using stream input.
        String convertedDocumentStream = conversionHandler.<String>convert(fileStream, Common.INPUT_GUID_FILE, saveOptions);

        fileStream.close();
    }

    /**
     * <p>
     * Converts stream input documents to Word Proccessing Document formats and
     * outputs the resulting document to a stream
     * </p>
     */
    public static void convertToWordFromStreamToStream() throws FileNotFoundException, IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // read input document as a stream
        FileInputStream fileStream = new FileInputStream(Paths.get(Common.STORAGE_PATH, Common.INPUT_GUID_FILE).toString());

        // Returns the converted Word Processing Documents as IO Stream using stream input.
        GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream>convert(fileStream, Common.INPUT_GUID_FILE, new WordsSaveOptions());
        fileStream.close();
    }

    /**
     * <p>
     * Convert file to Pdf format and get output as file path
     * </p>
     */
    public static void convertToPdfAsPath() throws IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // Convert and save converted Pdf documents.
        // Returns paths to the converted Pdf documents.
        PdfSaveOptions saveOptions = new PdfSaveOptions();
        saveOptions.setOutputType(OutputType.String);
        String convertedDocumentPath = conversionHandler.<String>convert(Common.INPUT_GUID_FILE, saveOptions);
    }

    /**
     * <p>
     * Converts documents to Pdf Document formats and outputs the resulting
     * document to a stream
     * </p>
     */
    public static void convertToPdfAsStream() throws IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // Convert and save converted Pdf documents. 
        // Returns the converted spreadsheet Pdf as IO Stream.
        GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream>convert(Common.INPUT_GUID_FILE, new PdfSaveOptions());
    }

    /**
     * <p>
     * In advance options example Convert Password Protected file to Pdf format
     * </p>
     */
    public static void convertToPdfAdvanceOptions() throws IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        //Set password to unprotect protected document during loading
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword("secret");
        // convert starting from page 2 and convert 2 pages,
        // use DPI 300, page width 1024, page height 768
        PdfSaveOptions saveOptions = new PdfSaveOptions();
        saveOptions.setPageNumber(2);
        saveOptions.setNumPagesToConvert(2);
        saveOptions.setDpi(300);
        saveOptions.setWidth(1024);
        saveOptions.setHeight(768);

        // Unprotect input document, Convert and save Pdf documents using advance options.
        // Returns the converted spreadsheet Pdf as IO Stream.
        GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream>convert(Common.INPUT_GUID_FILE, loadOptions, saveOptions);
    }

    /**
     * <p>
     * Converts stream input documents to pdf Document formats and outputs the
     * resulting document to a file path
     * </p>
     */
    public static void convertToPdfFromStreamToFile() throws FileNotFoundException, IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // read input document as a stream
        FileInputStream fileStream = new FileInputStream(Paths.get(Common.STORAGE_PATH, Common.INPUT_GUID_FILE).toString());

        PdfSaveOptions saveOptions = new PdfSaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setCustomName(FilenameUtils.removeExtension(Common.INPUT_GUID_FILE)); //Path.getFileNameWithoutExtension

        // Returns the converted pdf documents as File Path using stream input.
        String convertedDocumentStream = conversionHandler.<String>convert(fileStream, Common.INPUT_GUID_FILE, saveOptions);

        fileStream.close();
    }

    /**
     * <p>
     * Converts stream input documents to pdf Document formats and outputs the
     * resulting document to a stream
     * </p>
     */
    public static void convertToPdfFromStreamToStream() throws FileNotFoundException, IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // read input document as a stream
        FileInputStream fileStream = new FileInputStream(Paths.get(Common.STORAGE_PATH, Common.INPUT_GUID_FILE).toString());

        // Returns the converted pdf documents as IO Stream using stream input.
        GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream>convert(fileStream, Common.INPUT_GUID_FILE, new PdfSaveOptions());
        fileStream.close();
    }

    /**
     * <p>
     * Convert file to Presentation Document format and get output as file path
     * </p>
     */
    public static void convertToPresentationAsPath() throws IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // Convert and save converted presentation documents.
        // Returns paths to the converted presentation documents.
        SlidesSaveOptions saveOptions = new SlidesSaveOptions();
        saveOptions.setOutputType(OutputType.String);
        String convertedDocumentPath = conversionHandler.<String>convert(Common.INPUT_GUID_FILE, saveOptions);
    }

    /**
     * <p>
     * Converts documents to Presentation Document format and outputs the
     * resulting document to a stream
     * </p>
     */
    public static void convertToPresentationAsStream() throws IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // Convert and save converted presentation documents. 
        // Returns the converted presentation documents as IO Stream.
        GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream>convert(Common.INPUT_GUID_FILE, new SlidesSaveOptions());
    }

    /**
     * <p>
     * In advance options example Convert Password Protected file to
     * Presentation Document format
     * </p>
     */
    public static void convertToPresentationAdvanceOptions() throws IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        //Set password to unprotect protected document during loading
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword("secret");

        // convert file to Ppt, starting from page 2 and convert 2 pages,
        // use DPI 300, image width 1024, image height 768
        SaveOptions saveOptions = new SlidesSaveOptions();
        saveOptions.setConvertFileType(SlidesSaveOptions.SlidesFileType.Ppt);
        saveOptions.setPageNumber(2);
        saveOptions.setNumPagesToConvert(2);

        // Unprotect input document, Convert and save presentation documents using advance options.
        // Returns the converted presentation documents as IO Stream.
        GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream>convert(Common.INPUT_GUID_FILE, loadOptions, saveOptions);
    }

    /**
     * <p>
     * Converts stream input documents to Presentation Document formats and
     * outputs the resulting document to a file path
     * </p>
     */
    public static void convertToPresentationFromStreamToFile() throws IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // read input document as a stream
        FileInputStream fileStream = new FileInputStream(Paths.get(Common.STORAGE_PATH, Common.INPUT_GUID_FILE).toString());

        SlidesSaveOptions saveOptions = new SlidesSaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setCustomName(FilenameUtils.removeExtension(Common.INPUT_GUID_FILE));

        // Returns the converted presentation documents as File Path using stream input.
        String convertedDocumentStream = conversionHandler.<String>convert(fileStream, Common.INPUT_GUID_FILE, saveOptions);

        fileStream.close();
    }

    /**
     * <p>
     * Converts stream input documents to Presentation Document formats and
     * outputs the resulting document to a stream
     * </p>
     */
    public static void convertToPresentationFromStreamToStream() throws FileNotFoundException, IOException {
        // Instantiating the conversion handler from custom common class
        ConversionHandler conversionHandler = Common.getConversionHandler();

        // read input document as a stream
        FileInputStream fileStream = new FileInputStream(Paths.get(Common.STORAGE_PATH, Common.INPUT_GUID_FILE).toString());

        // Returns the converted presentation documents as IO Stream using stream input.
        GroupDocsInputStream convertedDocumentStream = conversionHandler.<GroupDocsInputStream>convert(fileStream, Common.INPUT_GUID_FILE, new SlidesSaveOptions());
        fileStream.close();
    }

    /**
     * <p>
     * Convert file and get output as file path using Custom Input Data Handler
     * </p>
     */
    public static void convertWithCustomInputDataHandler() throws IOException {
//        // Creating new conversionConfig class object with input and output files directory path
//        ConversionConfig conversionConfig = new ConversionConfig();
//        conversionConfig.setStoragePath(Common.STORAGE_PATH);
//        conversionConfig.setCachePath(Common.CACHE_PATH);
//        conversionConfig.setOutputPath(Common.OUTPUT_PATH);
//
//        // Instantiating the conversion handler from custom input data handler class
//        AmazonInputDataHandler inputDataHandler = new AmazonInputDataHandler("accessKey", "secretKey");
//        ConversionHandler conversionHandler = new ConversionHandler(conversionConfig, inputDataHandler);
//
//        PdfSaveOptions saveOptions = new PdfSaveOptions();
//
//        // Convert and save converted Pdf documents.
//        // Returns paths to the converted Pdf documents.
//        GroupDocsInputStream resultStream = conversionHandler.<GroupDocsInputStream>convert(Common.INPUT_GUID_FILE, saveOptions);
    }
    
    /**
     * <p>
     * Convert file and get output as file path using Custom Output Data Handler
     * </p>
     */
    public static void convertWithCustomOutputDataHandler() throws IOException {
        // Creating new conversionConfig class object with input and output files directory path
        ConversionConfig conversionConfig = new ConversionConfig();
        conversionConfig.setStoragePath(Common.STORAGE_PATH);
        conversionConfig.setCachePath(Common.CACHE_PATH);
        conversionConfig.setOutputPath(Common.OUTPUT_PATH);

        // Instantiating the conversion handler from custom output data handler class
        AmazonOutputDataHandler outputDataHandler = new AmazonOutputDataHandler(conversionConfig, "accessKey", "secretKey");
        ConversionHandler conversionHandler = new ConversionHandler(conversionConfig, (IOutputDataHandler) outputDataHandler);

        // Convert and save converted Pdf documents.
        // Returns paths to the converted Pdf documents.
        PdfSaveOptions saveOptions = new PdfSaveOptions();
        saveOptions.setOutputType(OutputType.String);
        String convertedDocumentPath = conversionHandler.<String>convert(Common.INPUT_GUID_FILE, saveOptions);

        System.out.println(convertedDocumentPath);
    }
    
    /**
     * <p>
     * Convert file and get Output as file path using Custom Cache Data Handler
     * </p>
     */
    public static void convertWithCustomCacheDataHandler() throws IOException {
        // Creating new conversionConfig class object with input and output files directory path
        ConversionConfig conversionConfig = new ConversionConfig();
        conversionConfig.setStoragePath(Common.STORAGE_PATH);
        conversionConfig.setCachePath(Common.CACHE_PATH);
        conversionConfig.setOutputPath(Common.OUTPUT_PATH);
        conversionConfig.setUseCache(true);

        // Instantiating the conversion handler from custom cache data handler class
        AmazonCacheDataHandler cacheDataHandler = new AmazonCacheDataHandler(conversionConfig, "accessKey", "secretKey");
        ConversionHandler conversionHandler = new ConversionHandler(conversionConfig, (ICacheDataHandler) cacheDataHandler);

        // Convert and save converted Pdf documents.
        // Returns paths to the converted Pdf documents.
        PdfSaveOptions saveOptions = new PdfSaveOptions();
        
        GroupDocsInputStream convertedDocumentPath = conversionHandler.<GroupDocsInputStream>convert(Common.INPUT_GUID_FILE, saveOptions);
    }
    
    /**
     * <p>
     * Convert file using Conversion Listners Interfaces
     * </p>
     */
    public static void convertUsingConversionLitenerAnddInterfaces() throws IOException {
        // Instantiating the conversion handler from custom common class
        ConversionManager manager = new ConversionManager(Common.STORAGE_PATH);
        String result = manager.convert(Common.INPUT_GUID_FILE);
        System.out.println(result);
    }

}