package br.com.timoteobrasil.ideotafeira.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.timoteobrasil.ideotafeira.modelo.Produto;
import br.com.timoteobrasil.ideotafeira.repository.ProdutoRepository;
import br.com.timoteobrasil.ideotafeira.to.ProdutoNovoTO;
import br.com.timoteobrasil.ideotafeira.to.ProdutoTO;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/")
    public List<ProdutoTO> getAll() {
        return produtoRepository.findAll()
            .stream().map(e -> modelMapper.map(e, ProdutoTO.class))
            .toList();
    }

    @GetMapping("/nada") 
    public Produto novoDummy() {
        System.out.println("Entrou no /nada");
        Produto produto = new Produto();
        produto.setNome("Nada");
        produto.setDescricao("Produto vazio para inicializar o banco.");
        return produtoRepository.save(produto);
    }

    @PostMapping("/novo")
    public ProdutoTO novo(@RequestBody ProdutoNovoTO produtoNovo) {
        Produto produto = produtoRepository.save(modelMapper.map(produtoNovo, Produto.class));
        return modelMapper.map(produto, ProdutoTO.class);
    }
}
