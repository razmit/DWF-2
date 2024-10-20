package com.desaf2.controller;

import com.desaf2.dao.AuthorDAO;
import com.desaf2.model.AuthorModel;
import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;

import java.util.List;

@ManagedBean(value = "authorBean")
@ViewScoped
public class AuthorBean {

    private AuthorModel author = new AuthorModel();
    private List<AuthorModel> authors;
    private AuthorDAO authorDAO = new AuthorDAO();

    @PostConstruct
    public void init(){
        authors = authorDAO.findAllAuthors();
    }

    public List<AuthorModel> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorModel> authors) {
        this.authors = authors;
    }
}

