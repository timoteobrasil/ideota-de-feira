package br.com.timoteobrasil.ideotafeira.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping("/nova")
    public CategoriaTO nova(@RequestBody CategoriaNovaTO categoriaNova) {
        Categoria categoria = categoriaRepository.save(modelMapper.map(categoriaNova, Categoria.class));
        return modelMapper.map(categoria, CategoriaTO.class);
    }
}
