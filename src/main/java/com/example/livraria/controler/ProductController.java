package com.example.livraria.controler;

import com.example.livraria.domain.products.Product;
import com.example.livraria.domain.products.ProductRequestDTO;
import com.example.livraria.domain.products.ProductResponseDTO;
import com.example.livraria.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductRepository repository;

    @PostMapping
    public ResponseEntity postProduct(@RequestBody @Valid ProductRequestDTO body){
        Product newProduct = new Product(body);

        this.repository.save(newProduct);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Transactional
    public ResponseEntity updadteProduct(@RequestBody @Valid ProductRequestDTO data){
        Optional<Product> optionalProduct = repository.findById(data.id());
        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setName(data.name());
            product.setCod(data.cod());
            product.setAutor(data.autor());
            product.setGenero(data.genero());
            product.setPreco(Float.valueOf(data.preco()));
            return ResponseEntity.ok(product);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity deleteProduct(@PathVariable String id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity getAllProducts(){
        List<ProductResponseDTO> productList = this.repository.findAll().stream().map(ProductResponseDTO::new).toList();

        return ResponseEntity.ok(productList);
    }
}