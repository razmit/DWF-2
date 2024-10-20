package com.desaf2.dao;

import com.desaf2.model.AuthorModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AuthorDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory(("AuthorsPU"));

    // CRUD
    public void createAuthor(AuthorModel author) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(author);
        em.getTransaction().commit();
        em.close();
    }

    public void updateAuthor(AuthorModel author){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(author);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteAuthor(Long id){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        AuthorModel author = em.find(AuthorModel.class, id);
        if (author != null){
            em.remove(author);
        }
        em.getTransaction().commit();
        em.close();
    }

    public AuthorModel findById(Long id){
        EntityManager em = emf.createEntityManager();
        AuthorModel author = em.find(AuthorModel.class, id);
        em.close();
        return author;
    }

    public List<AuthorModel> findAllAuthors(){
        EntityManager em = emf.createEntityManager();
        List<AuthorModel> authors = em.createQuery("SELECT a FROM AuthorModel a", AuthorModel.class).getResultList();
        em.close();
        return authors;
    }

}
