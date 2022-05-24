package ar.dino.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persona {

       @Id
       @GeneratedValue(strategy=GenerationType.AUTO)
       private int idPersona;
       @Column(name="nombre", length = 50)       //con esta anotacion le puedo decir que es la columna de una BBDD , no va a construir toda
       private String nombre;
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

       //crear getters y setters de las variables de campo


}