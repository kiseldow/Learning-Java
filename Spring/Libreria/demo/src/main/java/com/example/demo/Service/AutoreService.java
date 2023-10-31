package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Autore;
import com.example.demo.Entity.Libro;
import com.example.demo.Repository.AutoreRepository;
import com.example.demo.Repository.LibroRepository;

@Service
public class AutoreService {
    @Autowired
    AutoreRepository ar;

    @Autowired
    LibroRepository lr;

    public Autore salvaAutore(Autore autore) {
        return ar.save(autore);
    }

    public Autore getAutoreById(Long id) {
        return ar.findById(id).orElse(null);
    }

    public List<Autore> getAll() {
        return ar.findAll();
    }

    public Autore modifAutoreyById(Long id, String nome) {
        if (ar.findById(id) != null) {
            Autore autore = ar.findById(id).orElse(null);
            autore.setNome(nome);
            return autore;
        }
        return null;
    }

    public Autore addLibroToAutore(Long idAutore, Long idLibro) {
        Libro libro = lr.findById(idLibro).orElse(null);
        Autore autore = ar.findById(idAutore).orElse(null);
        if (autore != null && libro != null) {
            autore.setLibri(libro);
            libro.setAutori(autore);
            return autore;
        }
        return null;
    }

    public void deleteAutore(Long id) {
        ar.deleteById(id);
    }
}
