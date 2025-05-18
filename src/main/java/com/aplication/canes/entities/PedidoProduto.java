package com.aplication.canes.entities;

import java.io.Serializable;

import com.aplication.canes.entities.pk.PedidoProdutoPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido_produto")
public class PedidoProduto implements Serializable{
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PedidoProdutoPK id = new PedidoProdutoPK();
    
    private Integer quant;

    public PedidoProduto(){
    }

    public PedidoProduto(PedidoEntitie pedido, ProdutoEntitie produto, Integer quant) {
        super();
        id.setPedido(pedido);
        id.setProduto(produto);
        this.quant = quant;
    }

    public PedidoEntitie getPedido(){
        return id.getPedido();
    }

    public ProdutoEntitie getProduto(){
        return id.getProduto();
    }

    public PedidoProdutoPK getId() {
        return id;
    }

    public void setId(PedidoProdutoPK id) {
        this.id = id;
    }

    public Integer getQuant() {  
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
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
        PedidoProduto other = (PedidoProduto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    
}
