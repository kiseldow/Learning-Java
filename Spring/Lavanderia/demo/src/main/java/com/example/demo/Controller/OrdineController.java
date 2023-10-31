package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Ordine;
import com.example.demo.Service.OrdineService;

@RestController
@RequestMapping("/ordini")
public class OrdineController {
    @Autowired
    OrdineService ordineService;

    @GetMapping
    public List<Ordine> listaOrdini() {
        return ordineService.mostraTutti();
    }

    @GetMapping("/{id}")
    public Ordine dettaglioOrdine(@PathVariable Long id) {
        return ordineService.mostraOrdine(id);
    }

    @PostMapping
    public Ordine creaOrdine(@PathVariable Long id, @PathVariable List<Long> serviziScelti) {
        return ordineService.aggiungiNuovoOrdine(id, serviziScelti);

    }

    @PutMapping("/{id}")
    public Ordine modificaOrdine(@PathVariable Long idOrdine, @PathVariable Long idCliente,
            @PathVariable List<Long> serviziScelti) {
        return ordineService.modifiaCOrdine(idOrdine, idCliente, serviziScelti);

    }

    @DeleteMapping("/{id}")
    public void eliminaOrdine(@PathVariable Long id) {
        ordineService.eliminaOrdine(id);

    }
}