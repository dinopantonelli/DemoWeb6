package ar.dino.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.dino.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona , Integer> {

    
}
