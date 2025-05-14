package com.terumisushii.entities;

public class Produto {
  private Long id;
  private String nome;
  private String descricao;
  private Double preco;
  private String imageUrl;

  public Produto(Long id, String nome, String descricao, Double preco, String imageUrl) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
    this.imageUrl = imageUrl;
  }

  public Produto() {
  }

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

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getDescricaoCompleta() {
    return "Produto: " + nome + "\n" +
            "Descrição: " + descricao + "\n" +
            "Preço: R$ " + preco + "\n" +
            "Imagem: " + imageUrl;
  }

  public String atualizarPreco(Double novoPreco) {
    this.preco = novoPreco;
    return "Preço atualizado com sucesso!";
  }

  public void adicionarImagem(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  @Override
  public String toString() {
    return "Produto{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", descricao='" + descricao + '\'' +
            ", preco=" + preco +
            ", imageUrl='" + imageUrl + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Produto)) return false;

    Produto produto = (Produto) o;

    if (!id.equals(produto.id)) return false;
    if (!nome.equals(produto.nome)) return false;
    if (!descricao.equals(produto.descricao)) return false;
    if (!preco.equals(produto.preco)) return false;
    return imageUrl.equals(produto.imageUrl);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + nome.hashCode();
    result = 31 * result + descricao.hashCode();
    result = 31 * result + preco.hashCode();
    result = 31 * result + imageUrl.hashCode();
    return result;
  }
}
