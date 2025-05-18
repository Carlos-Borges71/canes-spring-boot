package com.aplication.canes.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="produto")
public class ProdutoEntitie implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer codigo;
    private String nome;
    private Integer estoque;
    private Double valorCompra;
    private Double valorVenda;
    private Integer quantcompra;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private FornecedorEntitie fornecedor;


    @OneToMany(mappedBy = "id.produto")
    private Set<PedidoProduto> pedidos = new HashSet<>();

    public ProdutoEntitie(){
    }

    public ProdutoEntitie(Integer id, Integer codigo, String nome, Integer estoque, Double valorCompra,
            Double valorVenda, Integer quantcompra, FornecedorEntitie fornecedor) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.estoque = estoque;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.quantcompra = quantcompra;
        this.fornecedor = fornecedor;
    }

      public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Integer getQuantcompra() {
        return quantcompra;
    }

    public void setQuantcompra(Integer quantcompra) {
        this.quantcompra = quantcompra;
    }
    
    @JsonIgnore
    public FornecedorEntitie getFornecedor(){
        return fornecedor;
    }
    
    @JsonIgnore
    public Set<PedidoProduto> getPedidos() {
        return pedidos;
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
        ProdutoEntitie other = (ProdutoEntitie) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
