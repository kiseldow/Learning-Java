package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Autore;
import com.example.demo.Entity.Libro;
import com.example.demo.Repository.AutoreRepository;
import com.example.demo.Repository.LibroRepository;

@Service
public class LibroService {
    @Autowired
    LibroRepository lr;

    @Autowired
    AutoreRepository ar;

    public Libro salvaLibro(Libro libro) {
        Libro newLibro = lr.save(libro);
        return newLibro;
    }

    public Libro getLibroById(Long id) {
        return lr.findById(id).orElse(null);
    }

    public List<Libro> getAll() {
        return lr.findAll();
    }

    public Libro modifyLibroById(Long id, String titolo) {
        if (lr.findById(id) != null) {
            Libro libro = lr.findById(id).orElse(null);
            libro.setTitolo(titolo);
            return libro;
        }
        return null;
    }

    public Libro addAutoreToLibro(Long idLibro, Long idAutore) {
        Libro libro = lr.findById(idLibro).orElse(null);
        Autore autore = ar.findById(idAutore).orElse(null);
        if (autore != null && libro != null) {
            libro.setAutori(autore);
            autore.setLibri(libro);
            return libro;
        }
        return null;
    }

    public void deleteLibro(Long id) {
        lr.deleteById(id);
    }

}
