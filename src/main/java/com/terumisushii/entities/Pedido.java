package com.terumisushii.entities;

import com.terumisushii.enums.formaPagamento;
import java.sql.Date;

public class Pedido {
  private Long id;
  private Date data;
  private Double total;
  private formaPagamento formaPagamento;

  public Pedido(Long id, Date data, Double total, formaPagamento formaPagamento) {
    this.id = id;
    this.data = data;
    this.total = total;
    this.formaPagamento = formaPagamento;
  }

  public Pedido() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public formaPagamento getFormaPagamento() {
    return formaPagamento;
  }

  public void setFormaPagamento(formaPagamento formaPagamento) {
    this.formaPagamento = formaPagamento;
  }

  public void adicionarItem(Produto produto, Double quantidade) {

  }

  public void removerItem(Produto produto) {

  }
  
  public double calcularTotal() {
    return 0; //furutamente ira calcular o total do pedido
  }

  public void finalizarPedido() {
  }

  @Override
  public String toString() {
    return "Pedido{" +
            "id=" + id +
            ", data=" + data +
            ", total=" + total +
            ", formaPagamento=" + formaPagamento +
            '}';
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Pedido)) return false;

    Pedido pedido = (Pedido) o;

    if (!id.equals(pedido.id)) return false;
    if (!data.equals(pedido.data)) return false;
    if (!total.equals(pedido.total)) return false;
    return formaPagamento == pedido.formaPagamento;
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + data.hashCode();
    result = 31 * result + total.hashCode();
    result = 31 * result + formaPagamento.hashCode();
    return result;
  }

}
