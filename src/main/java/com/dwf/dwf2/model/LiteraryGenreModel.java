package com.dwf.dwf2.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
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
    private Set<AuthorModel> authors = new HashSet<>();

    public Long getIdLitGenre() {
        return idLitGenre;
    }

    public void setIdLitGenre(Long idLitGenre) {
        this.idLitGenre = idLitGenre;
    }

    public String getNameLitGenre() {
        return nameLitGenre;
    }

    public void setNameLitGenre(String nameLitGenre) {
        this.nameLitGenre = nameLitGenre;
    }

    public Set<AuthorModel> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorModel> authors) {
        this.authors = authors;
    }
    // Override equals and hashCode based on 'id'
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LiteraryGenreModel that = (LiteraryGenreModel) o;
        return Objects.equals(idLitGenre, that.idLitGenre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLitGenre);
    }
}
