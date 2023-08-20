package br.com.timoteobrasil.ideotafeira.parser;

import br.com.timoteobrasil.ideotafeira.modelo.Produto;
import br.com.timoteobrasil.ideotafeira.to.ProdutoNovoTO;

public class ProdutoNovoParser implements IParser<Produto, ProdutoNovoTO> {

    @Override
    public Produto toEntity(ProdutoNovoTO to) {
        Produto entity = new Produto();
        entity.setNome(to.getNome());
        entity.setDescricao(to.getDescricao());
        return entity;
    }

    @Override
    public ProdutoNovoTO toTO(Produto entity) {
        throw new UnsupportedOperationException("TO apenas para escrita.");
    }
    
}
