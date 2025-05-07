package com.aplication.canes.resouces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplication.canes.entities.UsuarioEntitie;
import com.aplication.canes.services.UsuarioService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping(value = "/usuarios" )
public class UsuarioResouce {

    @Autowired
    private UsuarioService service;
 
    @RequestMapping( method=RequestMethod.GET)
    public ResponseEntity<?> findAll() {

        List<UsuarioEntitie> obj = service.findAll();

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id){

        UsuarioEntitie obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(@PathVariable Integer id){

         service.deleteById(id);

         return ResponseEntity.ok().body(null);
    }

}
