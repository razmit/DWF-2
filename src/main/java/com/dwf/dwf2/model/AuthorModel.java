package com.desaf2.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "author")
public class AuthorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAuthor;

    @NotNull(message = "Name is required")
    @Size(min = 3, max = 255, message = "Name must be between 3 and 255 characters")
    @Column(name = "nameAuthor", nullable = false)
    private String nameAuthor;

    @NotNull(message = "Birthday is required")
    @Past(message = "Birthday must be in the past")
    @Temporal(TemporalType.DATE)
    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @NotNull(message = "Phone number is required")
    @Column(name = "phoneNumber", nullable = false)
    private int phoneNumber;

    @NotNull(message = "Gender is required")
    @Column(name = "gender", nullable = false)
    private String gender;

    @ManyToMany
    @JoinTable(
            name = "authorgenre",
            joinColumns = @JoinColumn(name = "idAuthor"),
            inverseJoinColumns = @JoinColumn(name = "idLitGenre")
    )
    private Set<LiteraryGenreModel> literaryGenres;

    public Long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
