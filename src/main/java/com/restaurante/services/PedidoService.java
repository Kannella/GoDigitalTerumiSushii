package com.restaurante.services;

import com.restaurante.dto.ItemPedidoRequestDTO;
import com.restaurante.dto.ItemPedidoResponseDTO;
import com.restaurante.dto.PedidoRequestDTO;
import com.restaurante.dto.PedidoResponseDTO;
import com.restaurante.entities.Cliente;
import com.restaurante.entities.ItemPedido;
import com.restaurante.entities.Pedido;
import com.restaurante.entities.Produto;
import com.restaurante.repository.ClienteRepository;
import com.restaurante.repository.PedidoRepository;
import com.restaurante.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public PedidoResponseDTO registrarPedido(PedidoRequestDTO requestDTO) {
        Cliente cliente = clienteRepository.findById(requestDTO.clienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + requestDTO.clienteId()));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);

        BigDecimal valorTotalPedido = BigDecimal.ZERO;

        for (ItemPedidoRequestDTO itemDTO : requestDTO.itens()) {
            Produto produto = produtoRepository.findById(itemDTO.produtoId())
                    .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + itemDTO.produtoId()));

            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setPedido(pedido);
            itemPedido.setProduto(produto);
            itemPedido.setQuantidade(itemDTO.quantidade());
            itemPedido.setPrecoUnitario(produto.getPreco());

            pedido.getItens().add(itemPedido);

            valorTotalPedido = valorTotalPedido.add(
                    produto.getPreco().multiply(BigDecimal.valueOf(itemDTO.quantidade()))
            );
        }

        pedido.setValorTotal(valorTotalPedido);
        Pedido pedidoSalvo = pedidoRepository.save(pedido);
        return mapToPedidoResponseDTO(pedidoSalvo);
    }

    public List<PedidoResponseDTO> listarTodos() {
        return pedidoRepository.findAll().stream()
                .map(this::mapToPedidoResponseDTO)
                .collect(Collectors.toList());
    }

    public List<PedidoResponseDTO> relatorioPorPeriodo(LocalDateTime dataInicio, LocalDateTime dataFim) {
        return pedidoRepository.findByDataPedidoBetween(dataInicio, dataFim).stream()
                .map(this::mapToPedidoResponseDTO)
                .collect(Collectors.toList());
    }

    private PedidoResponseDTO mapToPedidoResponseDTO(Pedido pedido) {
        List<ItemPedidoResponseDTO> itensDTO = pedido.getItens().stream()
                .map(item -> new ItemPedidoResponseDTO(
                        item.getProduto().getId(),
                        item.getProduto().getNome(),
                        item.getQuantidade(),
                        item.getPrecoUnitario(),
                        item.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getQuantidade()))
                )).collect(Collectors.toList());

        return new PedidoResponseDTO(
                pedido.getId(),
                pedido.getCliente().getId(),
                pedido.getCliente().getNome(),
                pedido.getDataPedido(),
                pedido.getValorTotal(),
                itensDTO
        );
    }
}