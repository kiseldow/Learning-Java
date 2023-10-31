package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Autore;
import com.example.demo.Service.AutoreService;

import java.util.List;

@RestController
@RequestMapping("/Autori")
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @PostMapping
    public Autore aggiungiAutore(@RequestBody Autore autore) {
        return autoreService.salvaAutore(autore);
    }

    @PostMapping("/AggiungiLibri/{id}")
    public Autore aggiungiLibroAdAutore(@PathVariable Long idAutore, @RequestParam Long idLibro) {
        return autoreService.addLibroToAutore(idAutore, idLibro);
    }

    @GetMapping("/{id}")
    public Autore getAutoreById(@PathVariable Long id) {
        Autore autore = autoreService.getAutoreById(id);
        if (autore != null) {
            return autore;
        } else {
            return null;
        }
    }

    @GetMapping
    public List<Autore> getAllAutori() {
        return autoreService.getAll();
    }

    @PutMapping("/{id}")
    public Autore modifyAutoreById(@PathVariable Long id, @RequestParam String nome) {
        return autoreService.modifAutoreyById(id, nome);
    }

    @DeleteMapping("/{id}")
    public void deleteAutore(@PathVariable Long id) {
        autoreService.deleteAutore(id);
    }

}
