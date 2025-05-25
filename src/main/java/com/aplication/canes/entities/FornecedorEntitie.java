package com.aplication.canes.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fornecedor")
public class FornecedorEntitie implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String empresa;
    private String cnpjCpf;

    @OneToMany(mappedBy = "fornecedor")
    private Set<TelefoneEntitie> telefones = new HashSet<>();

    @OneToOne(mappedBy = "fornecedor")    
    private EnderecoEntitie endereco;

    @OneToMany(mappedBy = "fornecedor")
    private Set<NotaFiscalEntitie> notasFiscais = new HashSet<>();

    @OneToMany(mappedBy = "fornecedor")
    private Set<ProdutoEntitie> produtos = new HashSet<>();


    public FornecedorEntitie(){        
    }

    public FornecedorEntitie(Integer id, String empresa, String cnpjCpf) {
        this.id = id;
        this.empresa = empresa;
        this.cnpjCpf = cnpjCpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }
    
    public EnderecoEntitie getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntitie endereco) {
        this.endereco = endereco;
    }

    
    
    public Set<NotaFiscalEntitie> getNotasFiscais() {
        return notasFiscais;
    }
    
    @JsonIgnore
    public Set<ProdutoEntitie> getProdutos() {
        return produtos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @JsonIgnore
    public Set<TelefoneEntitie> getTelefones() {
        return telefones;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FornecedorEntitie other = (FornecedorEntitie) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
