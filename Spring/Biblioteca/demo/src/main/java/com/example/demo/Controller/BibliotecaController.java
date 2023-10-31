package com.example.demo.Controller;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Libro;
import com.example.demo.Membro;
import com.example.demo.Prenotazione;
import com.example.demo.Service.LibroService;
import com.example.demo.Service.MembroService;
import com.example.demo.Service.PrenotazioneService;

@RestController
@RequestMapping("/Biblioteca")
public class BibliotecaController {

    @Autowired
    LibroService ls;
    @Autowired
    MembroService ms;
    @Autowired
    PrenotazioneService ps;

    @GetMapping("/Libri")
    public Collection<Libro> getAllLibri() {
        return ls.mostraTutti();
    }

    @GetMapping("/Membri")
    public Collection<Membro> getAllMembri() {
        return ms.mostraTutti();
    }

    @GetMapping("/Prenotazioni")
    public Collection<Prenotazione> getAllPrenotazioni() {
        return ps.ottieniPrenotazioni();
    }

    @PostMapping("/Libri")
    public Libro aggiungiLibro(@RequestBody Libro libro) {
        return ls.aggiungiLibro(libro);
    }

    @PostMapping("/Membri")
    public Membro aggiungiMembro(@RequestBody Membro membro) {
        return ms.aggiungiMembro(membro);
    }

    @PostMapping("/Prenotazioni")
    public Prenotazione aggiungiPrenotazione(@RequestBody Long idMembro, @RequestBody LocalDate dataInizio,
            @RequestBody Long idLibro) {
        return ps.aggiungiPrenotazione(idMembro, dataInizio, idLibro);
    }

    @DeleteMapping("/Libri/{id}")
    public void eliminaLibro(@PathVariable Long id) {
        ls.eliminaLibro(id);
    }

    @DeleteMapping("/Membri/{id}")
    public void eliminaMembro(@PathVariable Long id) {
        ms.eliminaMembro(id);
    }

    @DeleteMapping("/Prenotazioni/{id}")
    public void eliminaPrenotazione(@PathVariable Long id) {
        ps.eliminaPrenotazione(id);
    }

    // Aggiungere PutMapping

}
