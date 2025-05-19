package com.aplication.canes.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.aplication.canes.entities.enums.Setor;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class UsuarioEntitie implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer setor;
    private String nome;
    private String login;

    @OneToMany(mappedBy = "operador")
    private Set<TelefoneEntitie> telefones = new HashSet<>();
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant instante;
    private String senha;

    @OneToMany(mappedBy = "id.operador")
    private Set<OperadorCliente> clientes = new HashSet<>();

    @OneToOne(mappedBy = "operador")
    private EnderecoEntitie endereco;

    public UsuarioEntitie(){        
    }

    public UsuarioEntitie(Integer id, Setor setor, String nome, String login, Instant instante, String senha) {
        this.id = id;
        setSetor(setor);
        this.nome = nome;
        this.login = login;
        this.instante = instante;
        this.senha = senha;
        
    }
   
    public List<ClienteEntitie> getClientes(){
        List<ClienteEntitie> lista = new ArrayList<>();
        for(OperadorCliente x : clientes){
            lista.add(x.getCliente());
        }
        return lista;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Setor getSetor() {
        return Setor.valueOf(setor);
    }

    public void setSetor(Setor setor) {
        if(setor != null) {
            this.setor =setor.getCode();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Instant getInstante() {
        return instante;
    }

    public void setInstante(Instant instante) {
        this.instante = instante;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

   
    // @JsonIgnore
    // public Set<OperadorCliente> getClientes() {
    //     return clientes;
    // }

    public void setClientes(Set<OperadorCliente> clientes) {
        this.clientes = clientes;
    }

    

    public Set<TelefoneEntitie> getTelefones() {
        return telefones;
    }
    

    @JsonIgnore
    public EnderecoEntitie getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntitie endereco) {
        this.endereco = endereco;
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
        UsuarioEntitie other = (UsuarioEntitie) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    
}
