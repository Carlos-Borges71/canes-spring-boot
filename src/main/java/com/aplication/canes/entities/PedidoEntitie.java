package com.aplication.canes.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.aplication.canes.entities.dto.ProdutoDPO;
import com.aplication.canes.entities.enums.EstadoPedido;
import com.aplication.canes.entities.enums.EstadoPedidoConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class PedidoEntitie implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Convert(converter = EstadoPedidoConverter.class)
    private EstadoPedido status;
    
    private Double valor;
    private Instant data;

    @OneToMany(mappedBy = "pedido")
    private Set<PagamentoEntitie> pagamentos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntitie cliente;

    @OneToMany(mappedBy = "id.pedido")
    private Set<PedidoProduto> pedido = new HashSet<>();

    public PedidoEntitie(){
    }

    public PedidoEntitie(Integer id, EstadoPedido status, Double valor, Instant data, ClienteEntitie cliente) {
        this.id = id;
        this.status = status;
        this.valor = valor;
        this.data = data;
        this.cliente = cliente;
    }   

    public List<ProdutoDPO> getProdutos(){
         List<ProdutoEntitie> lista = new ArrayList<>();
         for(PedidoProduto x : pedido){
            lista.add(x.getProduto());
         }
         return lista.stream().map(ProdutoDPO::new).collect(Collectors.toList());
     }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoPedido getStatus() {
        return status;
    }

    public void setStatus(EstadoPedido status) {
        this.status = status;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }
    
    
     public Set<PedidoProduto> getPedido() {
        return pedido;
    }

    
    public Set<PagamentoEntitie> getPagamentos() {
        return pagamentos;
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
        PedidoEntitie other = (PedidoEntitie) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

   
    
}
