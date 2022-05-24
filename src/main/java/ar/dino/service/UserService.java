package ar.dino.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.dino.model.Usuario;
import ar.dino.repo.IUsuarioRepo;

@Service   //le decimos que es servicio a Springboot
public class UserService implements UserDetailsService {
      

	
            @Autowired
            private  IUsuarioRepo repo;

             public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{  //el metodo pide que retornemos un objeto userdDetails PROBAR SI ANDA CON ID no con nombre

                Usuario us=repo.findByNombre(username);                          //el metodo nos dice que tenemos que buscarlo por nombre de usuario

                //roles de usuario que en una situacion real obtenga desde una BBDD, buscar esas clases
                List<GrantedAuthority> roles=new ArrayList<>();
                roles.add(new SimpleGrantedAuthority("ADMIN"));

                UserDetails userDet= new User(us.getNombre(),us.getClave(), roles);

                 return userDet;   //este es el que contiene la informacion del usuario que quiere iniciar sesion
           }
         

}
