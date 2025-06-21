package com.restaurante.services;

import com.restaurante.dto.ClienteDTO;
import com.restaurante.entities.Cliente;
import com.restaurante.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO criarCliente(ClienteDTO dto) {
        Cliente cliente = new Cliente(null, dto.nome(), dto.cpf(), dto.telefone(), dto.cep(), dto.numero(), dto.bairro());
        cliente = clienteRepository.save(cliente);
        return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getTelefone(), cliente.getCep(), cliente.getNumero(), cliente.getBairro());
    }

    public List<ClienteDTO> listarTodos() {
        return clienteRepository.findAll().stream()
                .map(c -> new ClienteDTO(c.getId(), c.getNome(), c.getCpf(), c.getTelefone(), c.getCep(), c.getNumero(), c.getBairro()))
                .collect(Collectors.toList());
    }
}