package br.com.timoteobrasil.ideotafeira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.timoteobrasil.ideotafeira.modelo.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
