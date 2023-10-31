package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Cliente;
import com.example.demo.Repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente mostraCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null) {
            return null;
        }
        return cliente;
    }

    public Cliente aggiungiNuovoCliente(Cliente cliente) {
        if (cliente != null) {
            return clienteRepository.save(cliente);
        }
        return null;
    }

    // se un trovo un cliente con l'id inserito lo modifico, altrimenti ne creo uno
    // nuovo
    public Cliente moficiaCliente(Cliente cliente) {
        if (cliente == null) {
            return null;
        }

        if (clienteRepository.existsById(cliente.getId())) {
            Cliente clienteModicifato = clienteRepository.findById(cliente.getId()).orElse(null);
            clienteModicifato.setCognome(cliente.getCognome());
            clienteModicifato.setEmail(cliente.getEmail());
            clienteModicifato.setNome(cliente.getNome());
            clienteModicifato.setNumeroTelefono(cliente.getNumeroTelefono());
            return clienteModicifato;
        }
        return clienteRepository.save(cliente);
    }

    public List<Cliente> ottieniTutti() {
        return clienteRepository.findAll();
    }

    public void eliminaCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
