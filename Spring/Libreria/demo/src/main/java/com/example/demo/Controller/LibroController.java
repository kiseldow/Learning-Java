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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Libro;
import com.example.demo.Service.LibroService;

@RestController
@RequestMapping("/Libri")
public class LibroController {
    @Autowired
    LibroService libroService;

    @PostMapping
    public Libro aggiungiLibro(@RequestBody Libro libro) {
        return libroService.salvaLibro(libro);
    }

    // Recupera un libro per ID
    @GetMapping("/{id}")
    public Libro getLibroById(@PathVariable Long id) {
        Libro libro = libroService.getLibroById(id);
        if (libro != null) {
            return libro;
        } else {
            return null;
        }
    }

    @PostMapping("/AggiungiAutore/{id}")
    public Libro aggiungiAutoreALibro(@PathVariable Long idLibro, @RequestParam Long idAutore) {
        return libroService.addAutoreToLibro(idLibro, idAutore);
    }

    // Recupera tutti i libri
    @GetMapping
    public List<Libro> getAllLibri() {
        return libroService.getAll();
    }

    // Modifica un libro per ID
    @PutMapping("/{id}")
    public Libro modifyLibroById(@PathVariable Long id, @RequestParam String titolo) {
        return libroService.modifyLibroById(id, titolo);
    }

    // Elimina un libro per ID
    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable Long id) {
        libroService.deleteLibro(id);
    }

}