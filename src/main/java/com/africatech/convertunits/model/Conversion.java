package com.africatech.convertunits.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * This is a bean used to convert the values
 */
public class Conversion {
    @NotEmpty(message = "convertFrom values can only take values from the list {KM, MI, CELCIUS, KELVIN, KG, LBS}")
    private String convertFrom;
    @NotEmpty(message = "convertTo values can only take values from the list {KM, MI, CELCIUS, KELVIN, KG, LBS}")
    private String convertTo;
    @NotNull(message = "convertValue should have a value")
    private Double convertValue;
    private Double convertedValue;
    private String message;

    public String getConvertFrom() {
        return convertFrom;
    }

    public void setConvertFrom(String convertFrom) {
        this.convertFrom = convertFrom;
    }

    public String getConvertTo() {
        return convertTo;
    }

    public void setConvertTo(String convertTo) {
        this.convertTo = convertTo;
    }

    public Double getConvertValue() {
        return convertValue;
    }

    public void setConvertValue(Double convertValue) {
        this.convertValue = convertValue;
    }

    public Double getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(Double convertedValue) {
        this.convertedValue = convertedValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
