package com.aplication.canes.entities.pk;

import java.io.Serializable;



import com.aplication.canes.entities.ClienteEntitie;
import com.aplication.canes.entities.UsuarioEntitie;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OperadorClientePK implements Serializable{
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "operador_id")
    private UsuarioEntitie operador;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntitie cliente;


    public UsuarioEntitie getOperador() {
        return operador;
    }
    public void setOperador(UsuarioEntitie operador) {
        this.operador = operador;
    }
    public ClienteEntitie getCliente() {
        return cliente;
    }
    public void setCliente(ClienteEntitie cliente) {
        this.cliente = cliente;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((operador == null) ? 0 : operador.hashCode());
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
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
        OperadorClientePK other = (OperadorClientePK) obj;
        if (operador == null) {
            if (other.operador != null)
                return false;
        } else if (!operador.equals(other.operador))
            return false;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        return true;
    }

    
    
}
