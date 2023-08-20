package br.com.timoteobrasil.ideotafeira.to;

public class CategoriaNovaTO {
    private String nome;
    private String descricao;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    @Override
    public String toString() {
        return "CategoriaNovaTO [nome=" + nome + ", descricao=" + descricao + "]";
    }
}
