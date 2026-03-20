package com.bn.clientecs.controllers;

import com.bn.clientecs.models.ClienteModel;
import com.bn.clientecs.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteModel> salvar(@RequestBody ClienteModel clienteModel) {
        ClienteModel request = clienteService.criar(clienteModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/clientes/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<ClienteModel>> listar() {
        List<ClienteModel> request = clienteService.listar();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> procurarPorId(@PathVariable Long id) {
        ClienteModel request = clienteService.procurarPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
