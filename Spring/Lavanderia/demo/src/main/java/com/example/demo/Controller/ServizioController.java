package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ServizioService;
import com.example.demo.Entity.Servizio;

@RestController
@RequestMapping("/servizi")
public class ServizioController {

    @Autowired
    private ServizioService servizioService;

    @GetMapping
    public List<Servizio> listaServizi() {
        return servizioService.mostraTutti();
    }

    @GetMapping("/{id}")
    public Servizio dettaglioServizio(@PathVariable Long id) {
        return servizioService.mostraServizio(id);

    }

    @PostMapping
    public Servizio creaServizio(@RequestBody Servizio servizio) {
        return servizioService.aggiungiServizio(servizio);
    }

    @PutMapping("/{id}")
    public Servizio modificaServizio(@PathVariable Long id, @PathVariable String tipo, @PathVariable double costo,
            @PathVariable int tempo) {
        return servizioService.modificaServizio(id, tipo, costo, tempo);

    }

    @DeleteMapping("/{id}")
    public void eliminaServizio(@PathVariable Long id) {
        servizioService.eliminaServizio(id);

    }
}