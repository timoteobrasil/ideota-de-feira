package br.com.timoteobrasil.ideotafeira.to;

import java.util.List;

public class EtiquetaTO {
    private Long id;
    private String nome;
    private List<String> produtosNomes;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<String> getProdutosNomes() {
        return produtosNomes;
    }
    public void setProdutosNomes(List<String> produtosNomes) {
        this.produtosNomes = produtosNomes;
    }
    @Override
    public String toString() {
        return "EtiquetaTO [id=" + id + ", nome=" + nome + "]";
    }
}
