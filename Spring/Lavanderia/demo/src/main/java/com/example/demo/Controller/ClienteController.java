package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Cliente;
import com.example.demo.Service.ClienteService;

@RestController
@RequestMapping("/clienti")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listaClienti() {
        return clienteService.ottieniTutti();
    }

    @GetMapping("/{id}")
    public Cliente mostraCliente(@PathVariable Long id) {
        return clienteService.mostraCliente(id);
    }

    @PostMapping
    public Cliente creaCliente(@RequestBody Cliente cliente) {
        return clienteService.aggiungiNuovoCliente(cliente);
    }

    @PutMapping("/{id}")
    public Cliente modifCliente(@RequestBody Cliente cliente) {
        return clienteService.moficiaCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminaCliente(@PathVariable Long id) {
        clienteService.eliminaCliente(id);
    }
}
