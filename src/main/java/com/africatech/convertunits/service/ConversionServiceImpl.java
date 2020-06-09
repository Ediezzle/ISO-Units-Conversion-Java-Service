package com.africatech.convertunits.service;


import com.africatech.convertunits.model.Conversion;
import org.springframework.stereotype.Service;

@Service
public class ConversionServiceImpl implements ConversionService {

    private static Double DISTANCE_RATIO = 0.621371;
    private static Double TEMPERATURE_FACTOR = 273.15;
    private static Double MASS_FACTOR = 0.453592;

    @Override
    public Conversion convertDistance(Conversion conversion) {
        if(conversion.getConvertFrom().equalsIgnoreCase("KM")){
            conversion.setConvertedValue(DISTANCE_RATIO * conversion.getConvertValue());
        }else if(conversion.getConvertFrom().equalsIgnoreCase("MI")){
            conversion.setConvertedValue(conversion.getConvertValue() / DISTANCE_RATIO);
        }

        return conversion;
    }

    @Override
    public Conversion convertTemperature(Conversion conversion) {
        if(conversion.getConvertTo().equalsIgnoreCase("CELCIUS")){
            conversion.setConvertedValue(conversion.getConvertValue() - TEMPERATURE_FACTOR);
        }else if(conversion.getConvertTo().equalsIgnoreCase("KELVIN")){
            conversion.setConvertedValue(conversion.getConvertValue() + TEMPERATURE_FACTOR);
        }
        return conversion;
    }
    
    @Override
    public Conversion convertWeight(Conversion conversion) {
        if(conversion.getConvertFrom().equalsIgnoreCase("LBS")){
            conversion.setConvertedValue(MASS_FACTOR * conversion.getConvertValue());
        }else if(conversion.getConvertFrom().equalsIgnoreCase("KG")){
            conversion.setConvertedValue(conversion.getConvertValue() / MASS_FACTOR);
        }

        return conversion;
    }
}
