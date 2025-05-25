package com.aplication.canes.entities.dto;

import com.aplication.canes.entities.ProdutoEntitie;

public class ProdutoDPO {

    private Integer id;
    private Integer codigo;
    private String nome;    
    private Double valorVenda;
    
    public ProdutoDPO(){        
    }

    public ProdutoDPO(ProdutoEntitie produto) {
        this.id = produto.getId();
        this.codigo = produto.getCodigo();
        this.nome = produto.getNome();
        this.valorVenda = produto.getValorVenda();
    }

    public Integer getId(){
        return id;
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

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }
    
}
