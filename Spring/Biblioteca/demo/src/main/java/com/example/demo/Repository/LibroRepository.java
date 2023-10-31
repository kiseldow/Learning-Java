package com.example.demo.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.Libro;

@Repository
public class LibroRepository {

    private Map<Long, Libro> libri = new HashMap<>();
    private Long currentId = 1L;

    public Libro aggiungi(Libro libro) {
        libro.setId(currentId++);
        libri.put(libro.getId(), libro);
        return libro;
    }

    public Collection<Libro> mostraTutti() {
        return libri.values();
    }

    public Libro mostraSingolo(Long id) {
        return libri.get(id);
    }

    public void elimina(Long id) {
        libri.remove(id);
    }

    public Libro modifica(Long id, Libro libro) {
        if (libri.containsKey(id)) {
            libro.setId(id);
            libri.put(id, libro);
            return libro;
        }
        return null;
    }

}
