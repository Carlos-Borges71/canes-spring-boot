package com.aplication.canes.resouces;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aplication.canes.entities.FornecedorEntitie;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorResouce {

    @RequestMapping(method = RequestMethod.GET)
    public List<FornecedorEntitie> listar(){

        FornecedorEntitie for1 = new FornecedorEntitie(1, "Cia roupas", "02.232.412/0001-02");
        FornecedorEntitie for2= new FornecedorEntitie(2, "TCI roupas", "10.236.589/0001/01");
        FornecedorEntitie for3= new FornecedorEntitie(3, "HD Fabrica", "25.698.897/001-02");

        List<FornecedorEntitie> lista = new ArrayList<>();
        lista.add(for1);
        lista.add(for2);
        lista.add(for3);

        return lista;
    }
}
