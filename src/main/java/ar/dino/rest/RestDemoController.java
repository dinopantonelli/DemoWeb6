package ar.dino.rest;

//VIDEO 8
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.dino.model.Persona;
import ar.dino.repo.IPersonaRepo;

@RestController
@RequestMapping("/personas")          //obligado a poner persona al lado de localhost
public class RestDemoController {


        @Autowired
        private IPersonaRepo repo;
       
        @GetMapping  //listado de un servicio, personas que lista
        public List<Persona> listar(){
            return repo.findAll();
        }
    
        @PostMapping  //insercion de datos
        public void insertar(@RequestBody Persona per){
            repo.save(per);
        }

         @PutMapping  //modificacion de datos, si encuentra un id ya con ese numero lo toma como actualizacion es una masa esto
        public  void modificar(@RequestBody Persona per){
            repo.save(per);
        }
       
         @DeleteMapping (value= "/{id}") //eliminacion de datos que viene de la URL
        public void eliminar(@PathVariable("id")Integer id){
            repo.deleteById(id);
        }
}

