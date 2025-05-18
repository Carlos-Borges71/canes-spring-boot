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

import com.aplication.canes.entities.OperadorCliente;
import com.aplication.canes.entities.pk.OperadorClientePK;
import com.aplication.canes.services.OperadorClienteService;

@RestController
@RequestMapping(value = "/operador_cliente")
public class OperadorClienteResource {

    @Autowired
    private OperadorClienteService service;

    @RequestMapping( method=RequestMethod.GET)
    public ResponseEntity<?> findAll() {

        List<OperadorCliente> obj = service.findAll();

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable OperadorClientePK id){

        OperadorCliente obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<OperadorCliente> insert(@RequestBody OperadorCliente obj){

        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(@PathVariable OperadorClientePK id){

         service.deleteById(id);

         return ResponseEntity.noContent().build(); 
   }

   @RequestMapping(value = "/{id}", method=RequestMethod.PUT)
   public ResponseEntity<OperadorCliente> update(@PathVariable OperadorClientePK id, @RequestBody OperadorCliente obj){
    obj = service.update(id, obj);
    return ResponseEntity.ok().body(obj);
   }
}
