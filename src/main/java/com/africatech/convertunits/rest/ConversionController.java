package com.africatech.convertunits.rest;

import com.africatech.convertunits.model.Conversion;
import com.africatech.convertunits.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ConversionController {

    @Autowired
    private ConversionService conversionService;

    @PostMapping("/kilometers-to-miles")
    public ResponseEntity<Conversion> convertKilometers(@Valid @RequestBody Conversion conversion){
        return getDistanceConversionBeanResponseEntity(conversion);
    }


    @PostMapping("/miles-to-kilometers")
    public ResponseEntity<Conversion> convertMiles(@Valid @RequestBody Conversion conversion){
        return getDistanceConversionBeanResponseEntity(conversion);
    }

    private ResponseEntity<Conversion> getDistanceConversionBeanResponseEntity(@RequestBody @Valid Conversion conversion) {
        StringBuffer stringBuffer = new StringBuffer();

        
        if(!(conversion.getConvertFrom().equalsIgnoreCase(conversion.getConvertTo())) 
        		&& (conversion.getConvertFrom().equalsIgnoreCase("KM"))&&
        		conversion.getConvertTo().equalsIgnoreCase("MI") || 
        		(conversion.getConvertFrom().equalsIgnoreCase("MI"))&&
        		conversion.getConvertTo().equalsIgnoreCase("KM")) {
        	
        
        conversion = conversionService.convertDistance(conversion);

        stringBuffer.append(conversion.getConvertValue() + " " + conversion.getConvertFrom() + " = " + conversion.getConvertedValue() + " " + conversion.getConvertTo());

        conversion.setMessage(stringBuffer.toString());

        return ResponseEntity.status(200)
                .body(conversion);
        }
        else {
        	conversion.setMessage("Bad request please provide valid distance requests");
        	return ResponseEntity.status(400)
                .body(conversion);
        }
    }

    @PostMapping("/kilograms-to-pounds")
    public ResponseEntity<Conversion> convertKilograms(@Valid @RequestBody Conversion conversion){
        return getWeightConversionBeanResponseEntity(conversion);
    }


    @PostMapping("/pounds-to-kilograms")
    public ResponseEntity<Conversion> convertPounds(@Valid @RequestBody Conversion conversion){
        return getWeightConversionBeanResponseEntity(conversion);
    }

    private ResponseEntity<Conversion> getWeightConversionBeanResponseEntity(@RequestBody @Valid Conversion conversion) {
        StringBuffer stringBuffer = new StringBuffer();

        
        if(!(conversion.getConvertFrom().equalsIgnoreCase(conversion.getConvertTo())) 
        		&& (conversion.getConvertFrom().equalsIgnoreCase("KG"))&&
        		conversion.getConvertTo().equalsIgnoreCase("LBS") || 
        		(conversion.getConvertFrom().equalsIgnoreCase("LBS"))&&
        		conversion.getConvertTo().equalsIgnoreCase("KG")) {
        	
        
        conversion = conversionService.convertWeight(conversion);

        stringBuffer.append(conversion.getConvertValue() + " " + conversion.getConvertFrom() + " = " + conversion.getConvertedValue() + " " + conversion.getConvertTo());

        conversion.setMessage(stringBuffer.toString());

        return ResponseEntity.status(200)
                .body(conversion);
        }
        else {
        	conversion.setMessage("Bad request please provide valid mass requests");
        	return ResponseEntity.status(400)
                .body(conversion);
        }
    }
    
    @PostMapping("/kelvin-to-celcius")
    public ResponseEntity<Conversion> convertKelvins(@Valid @RequestBody Conversion conversion){
        return getTemperatureConversionBeanResponseEntity(conversion);
    }

    private ResponseEntity<Conversion> getTemperatureConversionBeanResponseEntity(@RequestBody @Valid Conversion conversion) {
        StringBuffer stringBuffer = new StringBuffer();
        
        if(!(conversion.getConvertFrom().equalsIgnoreCase(conversion.getConvertTo())) 
        		&& (conversion.getConvertFrom().equalsIgnoreCase("celcius"))&&
        		conversion.getConvertTo().equalsIgnoreCase("kelvin") || 
        		(conversion.getConvertFrom().equalsIgnoreCase("kelvin"))&&
        		conversion.getConvertTo().equalsIgnoreCase("celcius")) {
        	
        
        conversion = conversionService.convertTemperature(conversion);

        stringBuffer.append(conversion.getConvertValue() + " degrees " + conversion.getConvertFrom() + " = " + conversion.getConvertedValue() +  " degrees " + conversion.getConvertTo());

        conversion.setMessage(stringBuffer.toString());

        return ResponseEntity.status(200)
                .body(conversion);
        }
        else {
        	conversion.setMessage("Bad request please provide valid temperature requests");
        	return ResponseEntity.status(400)
                .body(conversion);
        }
    }


    @PostMapping("/celcius-to-kelvin")
    public ResponseEntity<Conversion> convertCelcius(@Valid @RequestBody Conversion conversion){
        return getTemperatureConversionBeanResponseEntity(conversion);
    }

}
