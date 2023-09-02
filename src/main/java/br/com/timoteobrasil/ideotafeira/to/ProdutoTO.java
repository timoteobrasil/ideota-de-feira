package br.com.timoteobrasil.ideotafeira.to;

import java.util.List;

public class ProdutoTO {
    private Long id;
    private String nome;
    private String descricao;
    private Long categoriaId;
    private String categoriaNome;
    private List<String> etiquetasNomes;

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
    public Long getCategoriaId() {
        return categoriaId;
    }
    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
    public String getCategoriaNome() {
        return categoriaNome;
    }
    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }
    public List<String> getEtiquetasNomes() {
        return etiquetasNomes;
    }
    public void setEtiquetasNomes(List<String> etiquetasNomes) {
        this.etiquetasNomes = etiquetasNomes;
    }
    @Override
    public String toString() {
        return "ProdutoTO [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", categoriaId=" + categoriaId
                + ", categoriaNome=" + categoriaNome + ", etiquetasNomes=" + etiquetasNomes + "]";
    }
}
