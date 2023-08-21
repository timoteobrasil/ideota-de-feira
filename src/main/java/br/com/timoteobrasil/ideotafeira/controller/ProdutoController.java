package br.com.timoteobrasil.ideotafeira.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.timoteobrasil.ideotafeira.modelo.Categoria;
import br.com.timoteobrasil.ideotafeira.modelo.Produto;
import br.com.timoteobrasil.ideotafeira.repository.CategoriaRepository;
import br.com.timoteobrasil.ideotafeira.repository.ProdutoRepository;
import br.com.timoteobrasil.ideotafeira.to.ProdutoNovoTO;
import br.com.timoteobrasil.ideotafeira.to.ProdutoTO;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/")
    public List<ProdutoTO> getAll() {
        return produtoRepository.findAll()
            .stream().map(e -> modelMapper.map(e, ProdutoTO.class))
            .toList();
    }

    @GetMapping("/produto")
    public ProdutoTO obterPorId(@RequestParam(name = "id_produto") Long idProduto) {
        return produtoRepository.findById(idProduto)
                .map(c -> modelMapper.map(c, ProdutoTO.class))
                .orElse(null);
    }

    @PostMapping("/produto")
    public ProdutoTO novo(@RequestBody ProdutoNovoTO produtoNovo) {
        Produto produto = modelMapper.map(produtoNovo, Produto.class);
        produto.setId(null);

        Categoria categoria = categoriaRepository.getReferenceById(produto.getCategoria().getId());
        produto.setCategoria(categoria);
        produtoRepository.save(produto);
        return modelMapper.map(produto, ProdutoTO.class);
    }

    @PutMapping("/produto")
    public ProdutoTO alterar(@RequestBody ProdutoTO produtoAtualizado) {
        Produto produto = produtoRepository.save(modelMapper.map(produtoAtualizado, Produto.class));
        return modelMapper.map(produto, ProdutoTO.class);
    }

    @DeleteMapping("/produto")
    public void excluir(@RequestParam(name = "id_produto") Long idProduto) {
        Optional<Produto> produto = produtoRepository.findById(idProduto);
        if(produto.isPresent()) {
            produtoRepository.delete(produto.get());
        }
    }
}
