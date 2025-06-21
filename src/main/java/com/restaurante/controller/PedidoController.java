package com.restaurante.controller;

import com.restaurante.dto.PedidoRequestDTO;
import com.restaurante.dto.PedidoResponseDTO;
import com.restaurante.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*") // Permite requisições de qualquer origem
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> registrarPedido(@RequestBody PedidoRequestDTO requestDTO) {
        PedidoResponseDTO pedidoRegistrado = pedidoService.registrarPedido(requestDTO);
        return ResponseEntity.ok(pedidoRegistrado);
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> buscarPedidos(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim) {

        List<PedidoResponseDTO> pedidos;
        if (dataInicio != null && dataFim != null) {
            pedidos = pedidoService.relatorioPorPeriodo(dataInicio, dataFim);
        } else {
            pedidos = pedidoService.listarTodos();
        }
        return ResponseEntity.ok(pedidos);
    }
}