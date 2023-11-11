package com.example.livraria.domain.cliente;

public record ClienteResponseDTO(Long id,String name, Integer cpf, Integer telefone, Integer cep, String endereco) {
    public  ClienteResponseDTO(Cliente cliente){
        this(
                cliente.getId(),
                cliente.getName(),
                cliente.getCpf(),
                cliente.getTelefone(),
                cliente.getCep(),
                cliente.getEndereco()
        );
    }
}
