package com.example.livraria.domain.products;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "product")
@Entity(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String cod;

    private String titulo;
    private String name;

    private String genero;

    private String autor;

    private Float preco;





    public Product(ProductRequestDTO data){
        this.cod = data.cod();
        this.titulo = data.titulo();
        this.name = data.name();
        this.genero = data.genero();
        this.autor = data.autor();
        this.preco = Float.valueOf(data.preco());

    }
}