package com.aplication.canes.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aplication.canes.entities.UsuarioEntitie;
import com.aplication.canes.services.UsuarioService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





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

    @PostMapping
    public ResponseEntity<UsuarioEntitie> insert(@RequestBody UsuarioEntitie obj){

        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(@PathVariable Integer id){

         service.deleteById(id);

         return ResponseEntity.noContent().build(); 
   }

   @RequestMapping(value = "/{id}", method=RequestMethod.PUT)
   public ResponseEntity<UsuarioEntitie> update(@PathVariable Integer id, @RequestBody UsuarioEntitie obj){
    obj = service.update(id, obj);
    return ResponseEntity.ok().body(obj);
   }

}
