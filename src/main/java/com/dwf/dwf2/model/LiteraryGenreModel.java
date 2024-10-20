package com.desaf2.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "literarygenre")
public class LiteraryGenreModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLitGenre;

    @Column(name = "nameLitGenre", nullable = false)
    private String nameLitGenre;

    @ManyToMany(mappedBy = "literaryGenres")
    private Set<AuthorModel> authors;



}
