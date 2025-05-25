package com.aplication.canes.entities;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="nota_fiscal")
public class NotaFiscalEntitie implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer notaFiscal;
    private Instant data;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private FornecedorEntitie fornecedor;

  
    public NotaFiscalEntitie(){        
    }

    public NotaFiscalEntitie(Integer id, Integer notaFiscal, Instant data, FornecedorEntitie fornecedor) {
        this.id = id;
        this.notaFiscal = notaFiscal;
        this.data = data;
        this.fornecedor = fornecedor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(Integer notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
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
        NotaFiscalEntitie other = (NotaFiscalEntitie) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
