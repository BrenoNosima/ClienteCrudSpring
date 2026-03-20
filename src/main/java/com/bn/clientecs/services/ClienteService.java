package com.bn.clientecs.services;

import com.bn.clientecs.models.ClienteModel;
import com.bn.clientecs.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> listar() {
        return clienteRepository.findAll();
    }

    public ClienteModel procurarPorId(Long id) {
        return clienteRepository.findById(id).get();
    }

    public ClienteModel criar(ClienteModel clienteModel) {
        return clienteRepository.save(clienteModel);
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}
