package ar.dino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.dino.model.Persona;
import ar.dino.repo.IPersonaRepo;

@Controller
public class DemoController {

	 @Autowired
     private IPersonaRepo  repo;

	@GetMapping("/InsertoPersona")
	public String greeting(@RequestParam(name="name", required=false) String name, Model model) {

            /*Persona p=new Persona();
            p.setIdPersona(4);
            p.setNombre("Agustina");
            repo.save(p); //guardamos en la base de datos pero esto se hace en un paquete service */

		model.addAttribute("name", name); //le agrego al modlo el parametro
		return "InsertoPersona";//esta buscando la pagina de la vista no tiene que ver con la ruta del getMapping
	}

	
	
	
/////////////////VIDEO 7


    @GetMapping("/ListoPersona")
         public String greeting( Model model) {

            model.addAttribute("personas", repo.findAll()); //busco el modelo en la BBDD y lo agrego al parametro "personas" que se va al HTML
            return "ListoPersona";//esta buscando la pagina de la vista no tiene que ver con la ruta del getMapping
           }

}