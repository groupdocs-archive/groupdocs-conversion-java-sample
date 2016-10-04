/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupdocs.conversion;

//import com.aspose.ms.System.Environment;
//import com.aspose.ms.System.IO.Path;
//import com.aspose.ms.System.IO.Stream;
import com.groupdocs.conversion.config.ConversionConfig;
import com.groupdocs.conversion.handler.ConversionHandler;
import java.io.InputStream;

/**
 *
 * @author Alexander
 */
public class Common {

    // PROJECT_PATH property to set root directory
    public static String PROJECT_PATH = new java.io.File("Data/").getAbsolutePath();
    
    // STORAGE_PATH property to set input file/s directory
    public static String STORAGE_PATH = PROJECT_PATH + "/SampleFiles/";

    // CACHE_PATH property to set cache file/s directory
    public static String CACHE_PATH = PROJECT_PATH + "/Cache/";

    // OUTPUT_PATH property to set output file/s directory
    public static String OUTPUT_PATH = PROJECT_PATH + "/Output/";

    // LICENSE_PATH property to set GroupDocs.Conversion license file anme and path
    public static String LICENSE_PATH = PROJECT_PATH + "GroupDocs.Conversion.Java.lic";

    // INPUT_GUID_FILE property to set input file
    public static String INPUT_GUID_FILE = "DOCXsample.docx";

    // Instantiate GroupDocs.Conversion conversionConfig class object
    private static ConversionConfig conversionConfig = null;

    // Instantiate GroupDocs.Conversion ConversionHandler class object
    private static ConversionHandler conversionHandler = null;

    /**
     * <p>
     * Get GroupDocs ConversionHandler Object
     * </p>
     *
     * @return ConversionHandler
     */
    public static ConversionHandler getConversionHandler() {
        if (conversionConfig == null) {
            // Creating new conversionConfig class object with input and output files directory path
            conversionConfig = new ConversionConfig();
            conversionConfig.setStoragePath(STORAGE_PATH);
            conversionConfig.setCachePath(CACHE_PATH);
            conversionConfig.setOutputPath(OUTPUT_PATH);
        }

        // Set false to disable cache
        conversionConfig.setUseCache(false);

        // Creating new ConversionHandler class object with conversionConfig object
        conversionHandler = new ConversionHandler(conversionConfig);

        // Returns the ConversionHandler static object
        return conversionHandler;
    }

    /**
     * <p>
     * Get GroupDocs ConversionHandler Object
     * </p>
     *
     * @return ConversionHandler
     */
    public static ConversionHandler getConversionHandlerUsingCache(boolean isUseCache) {
        if (conversionConfig == null) {
            // Creating new conversionConfig class object with input and output files directory path
            conversionConfig = new ConversionConfig();
            conversionConfig.setStoragePath(STORAGE_PATH);
            conversionConfig.setCachePath(CACHE_PATH);
            conversionConfig.setOutputPath(OUTPUT_PATH);
        }

        // Set to use cache or not
        conversionConfig.setUseCache(isUseCache);

        // Creating new ConversionHandler class object with conversionConfig object
        conversionHandler = new ConversionHandler(conversionConfig);

        // Returns the ConversionHandler static object
        return conversionHandler;
    }

    /**
     * <p>
     * Applies GroupDocs.Conversion license
     * </p>
     *
     * @param filepath
     */
    public static void applyLicense(String filepath) {
        // Instantiate GroupDocs.Conversion license
        License license = new License();

        // Apply GroupDocs.Conversion license using license path
        license.setLicense(filepath);
    }

    /**
     * <p>
     * Applies GroupDocs.Conversion license using stream input
     * </p>
     *
     * @param licenseStream
     */
    public static void applyLicense(InputStream licenseStream) {
        // Instantiate GroupDocs.Conversion license
        License license = new License();

        // Apply GroupDocs.Conversion license using license file stream
        license.setLicense(licenseStream);
    }
}
