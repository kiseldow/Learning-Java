package com.example.demo.Controller;

import java.time.LocalDate;
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

import com.example.demo.Biglietto;
import com.example.demo.Service.BigliettoService;

@RestController
@RequestMapping("/biglietto")
public class BigliettoController {

    @Autowired
    private BigliettoService bs;

    @GetMapping
    public Collection<Biglietto> getAll() {
        return bs.getAll();
    }

    @GetMapping("/{id}")
    public Biglietto getBigliettoById(@PathVariable Long id) {
        if (bs.getBiglietto(id) != null) {
            System.out.println("ecco i dettagli del biglietto: ");
        } else {
            System.out.println("codice del biglietto non trovato");
        }
        return bs.getBiglietto(id);
    }

    @PostMapping
    public Biglietto nuovoBiglietto(@RequestBody Biglietto biglietto) {
        if (biglietto.getDataEvento().isBefore(LocalDate.now())) {
            System.out.println("Data non valida");
            return null;
        }

        if (biglietto.getPrezzo().signum() < 1) {
            System.out.println("Il prezzo deve essere positivo");
            System.out.println("COL CA**O CHE TI PAGHIAMO NOI");
            return null;
        }

        if (biglietto.getNomeEvento().isEmpty() || biglietto.getNomeCompratore().isEmpty()) {
            System.out.println("Se non mi dici che vuoi vedeere come faccio a venderti il biglietto");
            System.out.println("Decidiamo noi?");
            return null;
        }

        return bs.addBiglietto(biglietto);
    }

    @PutMapping("/{id}")
    public Biglietto aggiornaBiglietto(Long id, Biglietto biglietto) {

        if (biglietto.getDataEvento().isBefore(LocalDate.now())) {
            System.out.println("Data non valida");
            return null;
        }

        if (biglietto.getPrezzo().signum() < 1) {
            System.out.println("Il prezzo deve essere positivo");
            System.out.println("COL CA**O CHE TI PAGHIAMO NOI");
            return null;
        }

        if (biglietto.getNomeEvento().isEmpty() || biglietto.getNomeCompratore().isEmpty()) {
            System.out.println("Se non mi dici che vuoi vedeere come faccio a venderti il biglietto");
            System.out.println("Decidiamo noi?");
            return null;
        }
        return bs.aggiorna(id, biglietto);
    }

    @DeleteMapping("/{id}")
    public void elminaBiglietto(Long id) {
        if (bs.getBiglietto(id) != null) {
            System.out.println("biglietto rimosso correttamente ");
        } else {
            System.out.println("codice del biglietto non trovato");
        }
        bs.deleteBiglietto(id);
    }

    @GetMapping("/concerto")
    public Collection<Biglietto> getAllConcert() {
        return bs.getAllConcert();
    }

    @GetMapping("/teatro")
    public Collection<Biglietto> getAllTeatro() {
        return bs.getAllTeatro();
    }

    @GetMapping("/cinema")
    public Collection<Biglietto> getAllCinema() {
        return bs.getAllCinema();
    }
}
