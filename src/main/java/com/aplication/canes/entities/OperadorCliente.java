package com.aplication.canes.entities;

import java.io.Serializable;

import com.aplication.canes.entities.dto.UsuarioDPO;
import com.aplication.canes.entities.pk.OperadorClientePK;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "operador_cliente")
public class OperadorCliente implements Serializable{
    private static final long serialVersionUID = 1L;

    
    @EmbeddedId
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private OperadorClientePK id = new OperadorClientePK();

    public OperadorCliente(){
    }
    

    public OperadorCliente(UsuarioEntitie operador, ClienteEntitie cliente){   
        super();
        id.setOperador(operador);
        id.setCliente(cliente);     
    }
    
    
    public UsuarioDPO getOperador(){
        
        return new UsuarioDPO(id.getOperador());        
    }
   
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public ClienteEntitie getCliente(){
        return id.getCliente();
    }

     

    public OperadorClientePK getId() {
        return id;
    }


    public void setId(OperadorClientePK id) {
        this.id = id;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OperadorCliente other = (OperadorCliente) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
