package com.restaurante.controller;

import com.restaurante.dto.ProdutoDTO;
import com.restaurante.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "*") // Permite requisições de qualquer origem
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO dto) {
        ProdutoDTO produtoCriado = produtoService.criarProduto(dto);
        URI location = URI.create("/api/produtos/" + produtoCriado.id());
        return ResponseEntity.created(location).body(produtoCriado);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarTodos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }
}