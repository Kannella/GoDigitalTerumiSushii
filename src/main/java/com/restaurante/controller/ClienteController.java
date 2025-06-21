package com.restaurante.controller;

import com.restaurante.dto.ClienteDTO;
import com.restaurante.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*") // Permite requisições de qualquer origem
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> criarCliente(@RequestBody ClienteDTO dto) {
        ClienteDTO clienteCriado = clienteService.criarCliente(dto);
        URI location = URI.create("/api/clientes/" + clienteCriado.id());
        return ResponseEntity.created(location).body(clienteCriado);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarTodos() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }
}