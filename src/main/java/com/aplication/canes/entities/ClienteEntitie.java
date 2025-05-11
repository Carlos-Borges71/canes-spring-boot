package com.aplication.canes.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class ClienteEntitie implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Instant instante;
    
    @OneToMany(mappedBy = "id.cliente")
    private Set<OperadorCliente> usuarios = new HashSet<>();

    public ClienteEntitie(){
    }


    public ClienteEntitie(Integer id, String nome, Instant instante) {
        this.id = id;
        this.nome = nome;
        this.instante = instante;
        
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public Instant getInstante() {
        return instante;
    }


    public void setInstante(Instant instante) {
        this.instante = instante;
    }    


    public Set<OperadorCliente> getUsuarios() {
        return usuarios;
    }


    public void setUsuarios(Set<OperadorCliente> usuarios) {
        this.usuarios = usuarios;
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
        ClienteEntitie other = (ClienteEntitie) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
