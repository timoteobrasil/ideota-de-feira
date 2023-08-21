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
import br.com.timoteobrasil.ideotafeira.repository.CategoriaRepository;
import br.com.timoteobrasil.ideotafeira.to.CategoriaNovaTO;
import br.com.timoteobrasil.ideotafeira.to.CategoriaTO;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/")
    public List<CategoriaTO> getAll() {
        return categoriaRepository.findAll()
                .stream().map(e -> modelMapper.map(e, CategoriaTO.class))
                .toList();
    }

    @GetMapping("/categoria")
    public CategoriaTO obterPorId(@RequestParam(name = "id_categoria") Long idCategoria) {
        return categoriaRepository.findById(idCategoria)
                .map(c -> modelMapper.map(c, CategoriaTO.class))
                .orElse(null);
    }

    @PostMapping("/categoria")
    public CategoriaTO nova(@RequestBody CategoriaNovaTO categoriaNova) {
        Categoria categoria = categoriaRepository.save(modelMapper.map(categoriaNova, Categoria.class));
        return modelMapper.map(categoria, CategoriaTO.class);
    }

    @PutMapping("/categoria")
    public CategoriaTO alterar(@RequestBody CategoriaTO categoriaAtualizada) {
        Categoria categoria = categoriaRepository.save(modelMapper.map(categoriaAtualizada, Categoria.class));
        return modelMapper.map(categoria, CategoriaTO.class);
    }

    @DeleteMapping("/categoria")
    public void excluir(@RequestParam(name = "id_categoria") Long idCategoria) {
        Optional<Categoria> categoria = categoriaRepository.findById(idCategoria);
        if(categoria.isPresent()) {
            categoriaRepository.delete(categoria.get());
        }
    }
}
