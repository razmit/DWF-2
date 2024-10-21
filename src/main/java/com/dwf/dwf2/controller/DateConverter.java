package com.dwf.dwf2.controller;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@FacesConverter("dateConverter")
public class DateConverter implements Converter {

    // The format used for the date
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            // Parse the string into a Date object
            return dateFormat.parse(value);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Formato inválido de fecha, por favor use AAAA-MM-DD.");
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        // Convert the Date object into a string
        return dateFormat.format((Date) value);
    }
}
