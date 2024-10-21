package com.dwf.dwf2.controller;

import com.dwf.dwf2.dao.AuthorDAO;
import com.dwf.dwf2.dao.LiteraryGenreDAO;
import com.dwf.dwf2.model.AuthorModel;
import com.dwf.dwf2.model.LiteraryGenreModel;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Named("authorControllerBean")  // Managed beans en versión CDI
@RequestScoped
public class AuthorControllerBean {

    private AuthorModel author = new AuthorModel();
    private List<AuthorModel> authors;
    private Set<LiteraryGenreModel> selectedGenres = new HashSet<>();

    @Inject  // Inyecta AuthorDAO en lugar de inicializarlo manualmente
    private AuthorDAO authorDAO;

    @Inject
    private LiteraryGenreDAO literaryGenreDAO;

    @PostConstruct
    public void init() {
        authors = authorDAO.findAllAuthors();
    }

    public AuthorControllerBean() {
    }

    // Getters y Setters
    public List<AuthorModel> getAuthors() {
        return authors;
    }

    public void saveAuthorWithGenres() {

        if (author.getIdAuthor() == null) {
            author.setLiteraryGenres(selectedGenres);  // Asigna los géneros seleccionados al autor
            authorDAO.createAuthor(author);  // Guarda el autor
        } else {
            // Update si ya existe
            authorDAO.updateAuthor(author);
        }

        authors = authorDAO.findAllAuthors();

    }

    // Method carga la data para editar
    public void loadAuthorForEdit(Long authorId) {
        author = authorDAO.findById(authorId);  // Carga el autor por ID
    }

    public AuthorModel getAuthor() {
        return author;
    }

    public Set<LiteraryGenreModel> getSelectedGenres() {
        return selectedGenres;
    }

    public void deleteAuthor(Long authorId) {
        authorDAO.deleteAuthor(authorId);
        authors = authorDAO.findAllAuthors(); // Refresca la lista de autores
    }

    public void setSelectedGenres(Set<LiteraryGenreModel> selectedGenres) {
        this.selectedGenres = selectedGenres;
    }
}
