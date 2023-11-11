package com.example.livraria.domain.products;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public record ProductRequestDTO(
        String id,

        @NotBlank
        String cod,

        @NotBlank
        String titulo,

        @NotBlank
        String name,

        @NotBlank
        String genero,

        @NotBlank
        String autor,


        @NotNull
        Integer preco
) {
}