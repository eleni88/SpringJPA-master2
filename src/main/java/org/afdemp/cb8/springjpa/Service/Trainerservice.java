/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.cb8.springjpa.Service;

import java.util.List;
import org.afdemp.cb8.springjpa.Dao.TrainerDao;
import org.afdemp.cb8.springjpa.Dao.TrainerDaoImpl;
import org.afdemp.cb8.springjpa.entities.Trainer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Eleni
 */
public class Trainerservice {
   
    
    TrainerDaoImpl trd = new TrainerDaoImpl();
    
     public List<Trainer> listtrainers(){
     return trd.listtrainers();
     }
     
     public void deleteTrainerById(Integer id){
         trd.deleteTrainerById(id);
         //return false;
     }
     
     public Trainer findTrainerById(Integer id){
     return trd.findTrainerById(id);
     }
     
     public void saveTrainer(Trainer trainer) {
		trd.saveTrainer(trainer);
	}
     
     public void updateTrainer(Trainer trainer){
     trd.updateTrainer(trainer);
     }
    
}
