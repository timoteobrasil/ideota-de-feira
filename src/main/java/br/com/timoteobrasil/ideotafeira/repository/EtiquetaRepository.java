package br.com.timoteobrasil.ideotafeira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.timoteobrasil.ideotafeira.modelo.Etiqueta;

public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {
    
}
