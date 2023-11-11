package com.example.livraria.domain.cliente;

import jakarta.validation.constraints.NotBlank;

public record ClienteRequestDTO(
       String id,
        @NotBlank
        String name,

        @NotBlank
        Integer cpf,

        @NotBlank
        Integer telefone,

        @NotBlank
        Integer cep,

        @NotBlank
        String endereco

) {
}
