package br.com.timoteobrasil.ideotafeira.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.timoteobrasil.ideotafeira.modelo.Etiqueta;
import br.com.timoteobrasil.ideotafeira.repository.EtiquetaRepository;
import br.com.timoteobrasil.ideotafeira.to.EtiquetaTO;

@RestController
@RequestMapping("/etiquetas")
public class EtiquetaController {
    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/")
    public List<EtiquetaTO> getAll() {
        return etiquetaRepository.findAll()
            .stream().map(e -> modelMapper.map(e, EtiquetaTO.class))
            .toList();
    }

    @PostMapping("/etiqueta")
    public EtiquetaTO nova(@RequestBody EtiquetaTO etiqueta) {
        Etiqueta etiquetaNova = modelMapper.map(etiqueta, Etiqueta.class);
        // Apagando o id para criar uma etiqueta nova
        etiquetaNova.setId(null);
        return modelMapper.map(etiquetaRepository.save(etiquetaNova), EtiquetaTO.class);
    }

}
