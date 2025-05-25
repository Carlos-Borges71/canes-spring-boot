package com.aplication.canes.entities.dto;

import java.time.Instant;

import com.aplication.canes.entities.UsuarioEntitie;
import com.aplication.canes.entities.enums.Setor;

public class UsuarioDPO {

    private Integer id;    
    private Setor setor;
    private String nome;
    private Instant instante;

    public UsuarioDPO(){        
    }

    public UsuarioDPO(UsuarioEntitie operador) {
        this.id = operador.getId();
        this.setor = operador.getSetor();
        this.nome = operador.getNome();
        this.instante = operador.getInstante();
    
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
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
    
    
}
