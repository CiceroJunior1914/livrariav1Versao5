package com.example.livraria.controler;

import com.example.livraria.domain.pedido.Pedido;
import com.example.livraria.domain.products.Product;
import com.example.livraria.repositories.PedidoRepository;
import com.example.livraria.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public List<Pedido> listarPedido(){
        return pedidoRepository.findAll();
    }

    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {

        /*double total = calcularTotalPedido(pedido);
        pedido.setTotal(total);
        return pedidoRepository.save(pedido);
*/

        // Recupere os produtos com base nos IDs especificados no pedido
        List<Product> produtosDoPedido = pedido.getProduct().stream()
                .map(produto -> productRepository.findById(produto.getId()).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        // Verifique se pelo menos um produto foi encontrado
        if (produtosDoPedido.isEmpty()) {
            throw new IllegalArgumentException("Pelo menos um produto deve ser especificado no pedido.");
        }

        // Adicione os produtos ao pedido
        pedido.setProduct(produtosDoPedido);

        // Calcule o total do pedido com base nos produtos (lógica personalizada aqui)
        double total = calcularTotalPedido(pedido);
        pedido.setTotal(total);

        // Salve o pedido no banco de dados
        return pedidoRepository.save(pedido);
    }


    private double calcularTotalPedido(Pedido pedido) {
        // Lógica de cálculo do total do pedido (por exemplo, somar o preço de todos os produtos)
        return pedido.getProduct().stream().mapToDouble(Product::getPreco).sum();
    }
}
