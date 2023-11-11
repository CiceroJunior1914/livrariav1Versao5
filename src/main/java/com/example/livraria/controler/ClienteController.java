package com.example.livraria.controler;

import com.example.livraria.domain.cliente.Cliente;
import com.example.livraria.domain.cliente.ClienteRequestDTO;
import com.example.livraria.domain.cliente.ClienteResponseDTO;
import com.example.livraria.repositories.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

   @PostMapping
   public ResponseEntity postCliente(@RequestBody @Valid ClienteRequestDTO body){
       Cliente newCliente = new Cliente(body);
       this.repository.save(newCliente);
       return ResponseEntity.ok().build();

   }


    @GetMapping
    public ResponseEntity getAllCliente(){
        List<ClienteResponseDTO> clienteList = this.repository.findAll().stream().map(ClienteResponseDTO::new).toList();
        return  ResponseEntity.ok(clienteList);
        

    }

    @PatchMapping
    @Transactional
    public ResponseEntity updateClinete(@RequestBody @Valid ClienteRequestDTO data){
        Optional<Cliente> optionalCliente = repository.findById(data.id());
        if (optionalCliente.isPresent()){
            Cliente cliente = optionalCliente.get();
            cliente.setName(data.name());
            return ResponseEntity.ok(cliente);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletcCliente(@PathVariable String id){
        repository.deleteById(id);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("buscar/{name}")
    public List<Cliente> buscaCliente(@PathVariable String name){
       return repository.findByName(name);
    }




}
