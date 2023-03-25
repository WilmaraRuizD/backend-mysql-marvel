package com.example.PruebaCRUD.Controller;

import com.example.PruebaCRUD.Entity.Persona;
import com.example.PruebaCRUD.Service.PersonaServiceIMPL.PSIMPL;
import org.apache.el.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("CRUDRepo")
public class Controlador {

    @Autowired
    private PSIMPL impl;

    @GetMapping
    @RequestMapping(value = "ConsultarPersona",method = RequestMethod.GET)

    //Trae todas las personas por metodo GET
    public ResponseEntity<?>ConsultarPersonas(){
        List<Persona>listaPersona=this.impl.ConsultarPersona();
        return ResponseEntity.ok(listaPersona);
    }
    //Creapersona con el metodo POST

    @PostMapping
    @RequestMapping(value = "CrearPersonas",method = RequestMethod.POST)
    public ResponseEntity<?>CrearPersona(@RequestBody Persona persona){
        Persona PersonaCreada=this.impl.CrearPersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(PersonaCreada);
    }

    //Se modifica personas con metodo PUT
    @PutMapping
    @RequestMapping(value = "ModificarPersonas",method = RequestMethod.PUT)
    public ResponseEntity<?>ModificarPersona(@RequestBody Persona persona){
        Persona PersonaModificada=this.impl.ModificarPersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(PersonaModificada);
    }

    @GetMapping
    @RequestMapping(value = "BuscarPersonas/{id}",method = RequestMethod.GET)
    public ResponseEntity<?>BuscarPersona(@PathVariable int id){
        Persona Persona=this.impl.BuscarPersona(id);
        return ResponseEntity.ok(Persona);
    }

    @DeleteMapping
    @RequestMapping(value = "EliminarPersonas/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?>EliminarPersona(@PathVariable int id){
        this.impl.EliminarPersona(id);
        return ResponseEntity.ok().build();
    }

}
