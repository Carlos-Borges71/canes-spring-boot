package com.aplication.canes.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aplication.canes.entities.TelefoneEntitie;
import com.aplication.canes.services.TelefoneService;



@RestController
@RequestMapping(value = "/telefones")
public class TelefoneResouce {

    @Autowired
    private TelefoneService service;

    @RequestMapping( method=RequestMethod.GET)
    public ResponseEntity<?> findAll() {

        List<TelefoneEntitie> obj = service.findAll();

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id){

        TelefoneEntitie obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<TelefoneEntitie> insert(@RequestBody TelefoneEntitie obj){

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
   public ResponseEntity<TelefoneEntitie> update(@PathVariable Integer id, @RequestBody TelefoneEntitie obj){
    obj = service.update(id, obj);
    return ResponseEntity.ok().body(obj);
   }

}
