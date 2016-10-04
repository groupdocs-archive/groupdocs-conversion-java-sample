package com.groupdocs.conversion;

//import com.aspose.ms.System.IO.Path;
import com.groupdocs.conversion.converter.option.ImageSaveOptions;
import com.groupdocs.foundation.domain.FileType;
import java.nio.file.Paths;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        
        /// you can set Input and output paths and input file name along with license path common for all example methods.
        // PROJECT_PATH property to set root directory
        Common.PROJECT_PATH = new java.io.File("Data/").getAbsolutePath().replace("\\", "/");
        Common.STORAGE_PATH = Common.PROJECT_PATH + "/SampleFiles/";
        Common.CACHE_PATH = Common.PROJECT_PATH + "/Cache/";
        Common.OUTPUT_PATH = Common.PROJECT_PATH + "/Output/";
        Common.INPUT_GUID_FILE = "DOCXsample.docx";
        //Common.INPUT_GUID_FILE = "PPTSample.pptx";
        //Common.INPUT_GUID_FILE = "PDFsample.pdf";

        // Uncomment following lines and specify the licence file to embed product licence using file path.
        
        try {
            Common.LICENSE_PATH = Paths.get(Common.PROJECT_PATH, "GroupDocs.Conversion.Java.lic").toString();
            Common.applyLicense(Common.LICENSE_PATH);
        } catch(Exception e) {}
        
        // Uncomment following lines and specify the licence file to embed product licence using stream.
        //Stream licenseStream = File.Open(Path.Combine(Environment.CurrentDirectory, @"GroupDocs.total.lic"), FileMode.Open, FileAccess.Read);
        //Common.ApplyLicense(licenseStream);

        /// <summary>
        /// **** Convert Spreadsheet, PDF, Presentation, Document Processing  formats.
        /// </summary>

        // Convert file Spreadsheet Document formats and get output as file path
        Conversion.convertToSpreadsheetAsPath();

        // Convert file Spreadsheet Document formats and get output as Stream
        Conversion.convertToSpreadsheetStream();

        // In Advanced example Convert Password Protected file to Spreadsheet Document formats 
        Conversion.convertToSpreadsheetAdvanceOptions();

        // Converts stream input documents to Spreadsheet Document formats and outputs the resulting document to a file path
        Conversion.convertToSpreadsheetFromStreamToFile();

        // Converts stream input documents to Spreadsheet Document formats and outputs the resulting document to a stream
        Conversion.convertToSpreadsheetFromStreamToStream();

        // Convert file to PDF format and get output as file path
        Conversion.convertToPdfAsPath();

        // Convert file to PDF format and get output as Stream
        Conversion.convertToPdfAsStream();

        // In Advanced example Convert Password Protected file to PDF format
        Conversion.convertToPdfAdvanceOptions();

        // Converts stream input documents to pdf Document formats and outputs the resulting document to a file path
        Conversion.convertToPdfFromStreamToFile();

        // Converts stream input documents to pdf Document formats and outputs the resulting document to a stream
        Conversion.convertToPdfFromStreamToStream();

        // Convert file to Presentation Document format and get output as file path
        Conversion.convertToPresentationAsPath();

        // Convert file to Presentation Document format and get output as Stream
        Conversion.convertToPresentationAsStream();

        // Converts stream input documents to presentation Document formats and outputs the resulting document to a file path
        Conversion.convertToPresentationFromStreamToFile();

        // Converts stream input documents to presentation Document formats and outputs the resulting document to a stream
        Conversion.convertToPresentationFromStreamToStream();

        // Convert file to Word Processing Document format and get output as file path
        Conversion.convertToWordDocumentAsPath();

        // Convert file to Word Processing Document format and get output as Stream
        Conversion.convertToWordDocumentAsStream();

        // In Advanced example Convert Password Protected file to Word Processing Document format
        Conversion.convertToWordDocumentAdvanceOptions();

        // Converts stream input documents to Word Processing Document formats and outputs the resulting document to a file path
        Conversion.convertToWordFromStreamToFile();

        // Converts stream input documents to Word Processing Document formats and outputs the resulting document to a stream
        Conversion.convertToWordFromStreamToStream();

        /// <summary>
        /// **** Rendering and Converting to HTML and Image formats.
        /// </summary>

        // Converts and Render file to a HTML format and get output as file path
        Rendering.renderHTMLAsPath();

        // Converts and Render file as HTML format and get output as Stream
        Rendering.renderHTMLAsStream();

        // Converts and render stream input document to html format and get output as file path
        Rendering.renderToHTMLFromStreamToFile();

        // Converts and render stream input document to html and outputs the resulting document to a stream
        Rendering.renderToHTMLFromStreamToStream();

        // In Advanced example Converts and Render Password Protected file to Excel format
        Rendering.renderHTMLAdvanceOptions();

        // Converts and Render file to an Image format and get output as file path
        Rendering.renderImageAsPath(FileType.Tiff);

        // Converts and Render file to an Image format and get output as Stream
        Rendering.renderImageAsStream(FileType.Png);

        // In Advanced example Converts and Render Password Protected file to Image format
        Rendering.renderImageAdvanceOptions(FileType.Gif);

        // Converts and render stream input document to image format and get output as file path
        Rendering.renderToImageFromStreamToFile(FileType.Jpeg);

        // Converts and render stream input document to image and outputs the resulting document to a stream
        Rendering.renderToImageFromStreamToStream(FileType.Jpeg);

        // Convert file and get output as file path using Custom Input Data Handler
        //Conversion.convertWithCustomInputDataHandler();

        // Convert file and get output as file path using Custom Output Data Handler
        //Conversion.convertWithCustomOutputDataHandler();

        // Convert file and get Output as file path using Custom Cache Data Handler
        //Conversion.convertWithCustomCacheDataHandler();

        // Convert file using Conversion Listners Interfaces
        Conversion.convertUsingConversionLitenerAnddInterfaces();
    }
}
