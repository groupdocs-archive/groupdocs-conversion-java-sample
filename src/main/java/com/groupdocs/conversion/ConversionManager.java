/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.groupdocs.conversion;

import com.groupdocs.conversion.converter.option.OutputType;
import com.groupdocs.conversion.converter.option.PdfSaveOptions;
import com.groupdocs.conversion.handler.ConversionHandler;
import java.io.Console;
import java.io.IOException;

/**
 *
 * @author Alexander
 */
public class ConversionManager {

    private final ConversionHandler _conversionHandler;

    public ConversionManager(String path) {
        _conversionHandler = Common.getConversionHandler();
//        _conversionHandler.SetConversionProgressListener(this);
//        _conversionHandler.SetConversionStatusListener(this);
    }

//    public void conversionProgressChanged(ConversionProgressEventArgs args) {
//        Console.WriteLine("Conversion progress: %s %", args.Progress);
//    }
//
//    public void conversionStatusChanged(ConversionEventArgs args) {
//        Console.WriteLine("Conversion status changed to: %s", args.Status);
//    }

    public String convert(String file) throws IOException {
        PdfSaveOptions option = new PdfSaveOptions();
        option.setOutputType(OutputType.String);
        
        return _conversionHandler.<String>convert(file, option);
    }
}
