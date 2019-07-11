/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.cb8.springjpa.Dao;

import java.util.List;
import org.afdemp.cb8.springjpa.entities.Trainer;

/**
 *
 * @author Eleni
 */
public interface TrainerDao {
    public List<Trainer> listtrainers();
    public void createTrainer(Trainer trainer);
   //public Trainer updateTrainer(Trainer trainer);
    public boolean deleteTrainerById(Integer id);
   // public void deleteTrainer(Trainer trainer);
    public Trainer findTrainerById(Integer id);
    public void saveTrainer(Trainer trainer); 
    
    
    
    
}
