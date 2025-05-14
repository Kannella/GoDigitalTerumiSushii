package com.terumisushii.entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
  private Long id;
  private String nome;
  private String telefone;
  private String endereco;

  public Cliente(Long id, String nome, String telefone, String endereco) {
    this.id = id;
    this.nome = nome;
    this.telefone = telefone;
    this.endereco = endereco;
  }

  public Cliente() {
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

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public void atualizarDados(String nome, String telefone, String endereco) {
    this.nome = nome;
    this.telefone = telefone;
    this.endereco = endereco;
  }

  public List<Pedido> visualizarPedidos() {
    // Implementar lógica para visualizar pedidos do cliente
    return new ArrayList<>();
  }

  @Override
  public String toString() {
    return "Cliente{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", telefone='" + telefone + '\'' +
            ", endereco='" + endereco + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Cliente)) return false;

    Cliente cliente = (Cliente) o;

    if (!id.equals(cliente.id)) return false;
    if (!nome.equals(cliente.nome)) return false;
    if (!telefone.equals(cliente.telefone)) return false;
    return endereco.equals(cliente.endereco);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + nome.hashCode();
    result = 31 * result + telefone.hashCode();
    result = 31 * result + endereco.hashCode();
    return result;
  }

}
