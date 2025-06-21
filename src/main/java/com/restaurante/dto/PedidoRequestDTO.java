package com.restaurante.dto;

import java.util.List;

public record PedidoRequestDTO(Long clienteId, List<ItemPedidoRequestDTO> itens) {}

