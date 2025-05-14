package com.aplication.canes.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "telefone")
public class TelefoneEntitie implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntitie cliente;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntitie operador;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private FornecedorEntitie fornecedor;

    public TelefoneEntitie(){        
    }

    public TelefoneEntitie(Integer id, String numero, ClienteEntitie cliente, UsuarioEntitie operador,
            FornecedorEntitie fornecedor) {
        this.id = id;
        this.numero = numero;
        this.cliente = cliente;
        this.operador = operador;
        this.fornecedor = fornecedor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public ClienteEntitie getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntitie cliente) {
        this.cliente = cliente;
    }

    public UsuarioEntitie getOperador() {
        return operador;
    }

    public void setOperador(UsuarioEntitie operador) {
        this.operador = operador;
    }

    public FornecedorEntitie getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorEntitie fornecedor) {
        this.fornecedor = fornecedor;
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
        TelefoneEntitie other = (TelefoneEntitie) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
