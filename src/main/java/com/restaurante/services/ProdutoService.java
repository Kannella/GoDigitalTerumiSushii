package com.restaurante.services;

import com.restaurante.dto.ProdutoDTO;
import com.restaurante.entities.Produto;
import com.restaurante.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoDTO criarProduto(ProdutoDTO dto) {
        Produto produto = new Produto(null, dto.nome(), dto.descricao(), dto.preco(), dto.categoria());
        produto = produtoRepository.save(produto);
        return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getCategoria());
    }

    public List<ProdutoDTO> listarTodos() {
        return produtoRepository.findAll().stream()
                .map(p -> new ProdutoDTO(p.getId(), p.getNome(), p.getDescricao(), p.getPreco(), p.getCategoria()))
                .collect(Collectors.toList());
    }
}