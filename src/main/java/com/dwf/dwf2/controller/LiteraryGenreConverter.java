package com.dwf.dwf2.controller;

import com.dwf.dwf2.dao.LiteraryGenreDAO;
import com.dwf.dwf2.model.LiteraryGenreModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value = "literaryGenreConverter", managed = true)
@ApplicationScoped
public class LiteraryGenreConverter implements Converter {

    @Inject
    private LiteraryGenreDAO literaryGenreDAO;

    // Convert LiteraryGenreModel to a string (typically the ID)
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || !(value instanceof LiteraryGenreModel)) {
            return "";
        }
        return String.valueOf(((LiteraryGenreModel) value).getIdLitGenre());  // Assuming 'id' is the identifier field
    }

    // Convert the string (ID) back to LiteraryGenreModel by looking it up in the DAO
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(value);
        return literaryGenreDAO.findById(id);  // Lookup the LiteraryGenreModel by ID from the database
    }
}
