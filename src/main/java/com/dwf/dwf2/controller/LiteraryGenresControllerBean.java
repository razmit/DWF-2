package com.dwf.dwf2.controller;

import com.dwf.dwf2.dao.LiteraryGenreDAO;
import com.dwf.dwf2.model.LiteraryGenreModel;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named("literaryGenresControllerBean")  // Managed beans en versión CDI
@RequestScoped
public class LiteraryGenresControllerBean {

    @Inject
    private LiteraryGenreDAO literaryGenreDAO;

    public List<LiteraryGenreModel> getGenres() {
        return literaryGenreDAO.findAllGenres();  // Lista de los géneros literarios
    }
}
