package com.example.PruebaCRUD.Respository;

import com.example.PruebaCRUD.Entity.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepo extends CrudRepository <Persona, Integer>{
}
