package ar.dino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.dino.service.UserService;

@Configuration
@EnableWebSecurity   //Video 10
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired   
    private UserService  userDetailService;

	 @Autowired
     private BCryptPasswordEncoder bcrypt;
	
	 @Bean // esta anotacion sirve para poder declarar y tener una instancia en el core container de spring, para que otra capa pueda llamarla a traves de un Autowired
     public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;          
    }   

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		 auth.userDetailsService(userDetailService).passwordEncoder(bcrypt);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}      
     
     
     
     
     
}
