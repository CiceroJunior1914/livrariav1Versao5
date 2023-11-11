package com.example.livraria.domain.products;

public record ProductResponseDTO(String id, String cod, String titulo, String name, String genero, String autor, Float preco) {
    public ProductResponseDTO(Product product){
        this(product.getId(), product.getCod(), product.getTitulo(), product.getName(), product.getGenero(), product.getAutor(), product.getPreco() );
    }
}