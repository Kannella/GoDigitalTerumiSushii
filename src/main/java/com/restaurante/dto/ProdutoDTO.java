package com.restaurante.dto;

import com.restaurante.enums.Categoria;

import java.math.BigDecimal;

public record ProdutoDTO(Long id, String nome, String descricao, BigDecimal preco, Categoria categoria) {}
