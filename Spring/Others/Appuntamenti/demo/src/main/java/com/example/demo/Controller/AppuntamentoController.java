package com.example.demo.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Appuntamento;
import com.example.demo.Service.AppuntamentoService;

@RestController
@RequestMapping("/appuntamenti")
public class AppuntamentoController {

    @Autowired
    private AppuntamentoService service;

    @GetMapping
    public Collection<Appuntamento> listaAppuntamenti() {
        return service.ottieniTutti();
    }

    @GetMapping("/{id}")
    public Appuntamento ottieniAppuntamento(@PathVariable Long id) {
        return service.ottieniPerId(id);
    }

    @PostMapping
    public Appuntamento nuovAppuntamento(@RequestBody Appuntamento appuntamento) {
        return service.aggiungiAppuntamento(appuntamento);
    }

    @PutMapping("/{id}")
    public Appuntamento aggiornaAppuntamento(@PathVariable Long id, @RequestBody Appuntamento appuntamento) {
        return service.aggiornaAppuntamento(id, appuntamento);
    }

    @DeleteMapping("/{id}")
    public void eliminaAppuntamento(@PathVariable Long id) {
        service.eliminaAppuntamento(id);
    }
}
