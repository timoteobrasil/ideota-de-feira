package br.com.timoteobrasil.ideotafeira.parser;

import br.com.timoteobrasil.ideotafeira.modelo.Produto;
import br.com.timoteobrasil.ideotafeira.to.ProdutoTO;

public class ProdutoParser implements IParser<Produto, ProdutoTO> {

    @Override
    public Produto toEntity(ProdutoTO to) {
        Produto entity = new Produto();
        entity.setId(to.getId());
        entity.setNome(to.getNome());
        entity.setDescricao(to.getDescricao());
        return entity;
    }

    @Override
    public ProdutoTO toTO(Produto entity) {
        ProdutoTO to = new ProdutoTO();
        to.setId(entity.getId());
        to.setNome(entity.getNome());
        to.setDescricao(entity.getDescricao());
        return to;
    }
    
}
