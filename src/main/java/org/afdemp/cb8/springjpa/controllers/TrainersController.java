package org.afdemp.cb8.springjpa.controllers;

import java.util.Locale;
import javax.validation.Valid;
import org.afdemp.cb8.springjpa.Service.Trainerservice;
import org.afdemp.cb8.springjpa.entities.Trainer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/trainers")
public class TrainersController {

    Trainerservice ts = new Trainerservice();

//	@RequestMapping(method = RequestMethod.GET)
//	public String sayHello(ModelMap model) {
//		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
//		return "index";
//	}
    //get all trainers
    @RequestMapping(method = RequestMethod.GET)
    public String getAllTrainers(ModelMap model) {
        model.addAttribute("greeting", ts.listtrainers());
        return "trainer";
    }

    //delete trainer
    @RequestMapping(value = {"/delete/{id}"}, method = RequestMethod.GET)
    public String deleteTrainer(@PathVariable Integer id, ModelMap model) {
        Trainer trainer = new Trainer();
        ts.deleteTrainerById(id);
        
        model.addAttribute("success", "Trainer deleted successfully");
        return "success";
        
    }

    //update trainer
    @RequestMapping(value = {"/update/{id}"}, method = RequestMethod.GET)
    public String editTrainer(@PathVariable Integer id, ModelMap model) {
        Trainer tr = ts.findTrainerById(id);

        model.addAttribute("trainer", tr);
        model.addAttribute("edit", false);
        return "registration";
    }

    @RequestMapping(value = {"/update/{id}"}, method = RequestMethod.POST)
    public String updateTrainer(@Valid Trainer trainer, BindingResult result,
            ModelMap model, @PathVariable Integer id) {

        if (result.hasErrors()) {
            return "registration";
        }
        ts.updateTrainer(trainer);

        model.addAttribute("success", "Trainer " + trainer.getFirstName() + " updated successfully");
        return "success";
    }

    //insert a trainer
    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String insert(ModelMap model) {
        Trainer trainer = new Trainer();
        model.addAttribute("trainer", trainer);
        model.addAttribute("edit", false);
        return "registration";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveTrainer(@Valid Trainer trainer, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }
        ts.saveTrainer(trainer);
        model.addAttribute("success", "Trainer " + trainer.getFirstName() + " registered successfully");
        return "success";

    }

}
