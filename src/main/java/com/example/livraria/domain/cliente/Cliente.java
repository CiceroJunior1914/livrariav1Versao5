package com.example.livraria.domain.cliente;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "clientes")
@Entity(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer cpf;

    private Integer telefone;

    private Integer cep;

    private String endereco;

    public Cliente(ClienteRequestDTO data){
        this.name = data.name();
        this.cpf = data.cpf();
        this.telefone = data.telefone();
        this.cep = data.cep();
        this.endereco = data.endereco();
    }

}
