package ar.dino.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.dino.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario , Integer> {

	
	Usuario findByNombre(String Nombre);
}
