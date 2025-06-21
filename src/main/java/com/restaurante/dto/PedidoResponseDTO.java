package com.restaurante.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record PedidoResponseDTO(
        Long pedidoId,
        Long clienteId,
        String nomeCliente,
        LocalDateTime dataPedido,
        BigDecimal valorTotal,
        List<ItemPedidoResponseDTO> itens
) {}