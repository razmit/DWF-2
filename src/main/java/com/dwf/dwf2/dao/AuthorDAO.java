package com.dwf.dwf2.dao;

import com.dwf.dwf2.model.AuthorModel;
import com.dwf.dwf2.model.LiteraryGenreModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Persistence;

import java.util.List;

@ApplicationScoped
public class AuthorDAO {


    private EntityManagerFactory emf;

    public AuthorDAO() {
        // Initialize EntityManagerFactory with the persistence unit name
        this.emf = Persistence.createEntityManagerFactory("AuthorsPU");
    }

    // CRUDs

    public void saveAuthorAndGenre(AuthorModel author, LiteraryGenreModel genre) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            author.getLiteraryGenres().add(genre); // Género con autor

            //Guarda el autor
            em.persist(author);
            em.getTransaction().commit();

        }catch (Exception e){
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }

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
        return em.createQuery("SELECT a FROM AuthorModel a", AuthorModel.class).getResultList();
    }

}
