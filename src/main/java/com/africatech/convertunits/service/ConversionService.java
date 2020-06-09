package com.africatech.convertunits.service;
import com.africatech.convertunits.model.*;
public interface ConversionService {
    Conversion convertDistance(Conversion conversionBean);

    Conversion convertTemperature(Conversion conversionBean);
    
    Conversion convertWeight(Conversion conversionBean);
}
