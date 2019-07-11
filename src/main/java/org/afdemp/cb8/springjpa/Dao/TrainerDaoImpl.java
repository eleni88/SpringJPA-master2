/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.cb8.springjpa.Dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.afdemp.cb8.springjpa.entities.Trainer;

/**
 *
 * @author Eleni
 */
public class TrainerDaoImpl implements TrainerDao{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.afdemp.cb8_SpringJPA_war_1.0PU");
    
    public List<Trainer> listtrainers(){
       EntityManager em = emf.createEntityManager();
        List<Trainer> tr = em.createNamedQuery("Trainer.findAll").getResultList();
           
        return tr;
    
    }
    
    public Trainer findTrainerById(Integer id){
        EntityManager em = emf.createEntityManager();
        Trainer trainer = new Trainer();
        try{
        trainer = (Trainer)em.createNamedQuery("Trainer.findByTrainerId").setParameter("trainerId", id).getSingleResult();
        
        }
        catch(Exception e){
        e.printStackTrace();
        }
        finally{
        em.close();
        emf.close();
        }
    return trainer;
    }
    
    
     public boolean deleteTrainerById(Integer id){
     EntityManager em = emf.createEntityManager();
     em.getTransaction().begin();
     
     try{
         System.out.println(em.createNamedQuery("Trainer.deleteById").setParameter("trainerId", id).executeUpdate());
         em.getTransaction().commit();
     }
     catch(Exception e){
         System.out.println("Exception");
     }
           finally{  
         em.close();}
         return false;
     }
    
    public void createTrainer(Trainer trainer){
         EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
      
    }
public void saveTrainer(Trainer trainer) {
EntityManager em = emf.createEntityManager();
em.getTransaction().begin();
em.persist(trainer);
em.getTransaction().commit();
}
    
     
}
    
    
    

    

