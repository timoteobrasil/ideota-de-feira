package br.com.timoteobrasil.ideotafeira.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.timoteobrasil.ideotafeira.to.Nada;

@RestController
public class ListaController {

    @GetMapping("/")
    public String hello() {
        return "Ideota de feira v0.0.1";
    }

    @GetMapping("/lista")
    public List<Nada> obterListaRecente() {
        List<Nada> lista = new ArrayList<>();
        for(int i = 0; i< 10; i++) {
            lista.add(new Nada("Produto " + i, i));
        }

        return lista;
    }
}
