package br.com.timoteobrasil.ideotafeira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.timoteobrasil.ideotafeira.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
