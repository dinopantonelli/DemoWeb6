package ar.dino;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.dino.model.Usuario;
import ar.dino.repo.IUsuarioRepo;

@SpringBootTest
class Demo6ApplicationTests {

	 @Autowired
     private IUsuarioRepo repo;

    @Autowired
    private BCryptPasswordEncoder encoder;

     @Test
	public void crearUsuarioTest(){
  
       Usuario us= new Usuario();
       us.setId(2);
       us.setNombre("Dino");	
       us.setClave(encoder.encode("741"));
       Usuario retorno=repo.save(us); //le pasamos el usuario, pero para que sea una prueba debe comprobarse una verdad o una flasedad

       assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave())); 
	}   
}
