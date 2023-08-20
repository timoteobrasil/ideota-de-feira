package br.com.timoteobrasil.ideotafeira.to;

public class ProdutoTO {
    private Long id;
    private String nome;
    private String descricao;
    private String categoriaNome;

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
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getCategoriaNome() {
        return categoriaNome;
    }
    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }
    @Override
    public String toString() {
        return "ProdutoTO [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", categoriaNome="
                + categoriaNome + "]";
    }
}
