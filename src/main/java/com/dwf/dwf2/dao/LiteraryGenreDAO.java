package com.dwf.dwf2.dao;

import com.dwf.dwf2.model.AuthorModel;
import com.dwf.dwf2.model.LiteraryGenreModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

@ApplicationScoped
public class LiteraryGenreDAO {

    private EntityManagerFactory emf;

    public LiteraryGenreDAO() {
        // Initialize EntityManagerFactory with the persistence unit name
        this.emf = Persistence.createEntityManagerFactory("AuthorsPU");
    }

    public List<LiteraryGenreModel> findAllGenres(){
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT g FROM LiteraryGenreModel g", LiteraryGenreModel.class).getResultList();
        } finally {
            em.close();
        }
    }

    public LiteraryGenreModel findById(Long id){
        EntityManager em = emf.createEntityManager();
        LiteraryGenreModel genre = em.find(LiteraryGenreModel.class, id);
        em.close();
        return genre;
    }
}
