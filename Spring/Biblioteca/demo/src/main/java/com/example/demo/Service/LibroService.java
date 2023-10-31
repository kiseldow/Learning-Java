package com.example.demo.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Libro;
import com.example.demo.Repository.LibroRepository;

@Service
public class LibroService {
    @Autowired
    LibroRepository lr;

    public Libro aggiungiLibro(Libro libro) {
        if (libro.getAutore().isBlank() ||
                libro.getGenere().isBlank() ||
                libro.getTitolo().isBlank()) {
            System.out.println("Inserimento dati non corretto");
            return null;
        }

        if (libro.getAnnoPubblicazione() <= 0) {
            System.out.println("L'anno di pubblicazione deve essere un numero positivo");
            return null;
        }

        if (libro.getQuantitaDisponibile() < 0) {
            System.out.println("La quantita` disponibile non puo` essere negativa");
            return null;
        }
        return lr.aggiungi(libro);
    }

    public Libro modificaLibro(Long id, Libro libro) {
        if (libro.getAutore().isBlank() ||
                libro.getGenere().isBlank() ||
                libro.getTitolo().isBlank()) {
            System.out.println("Inserimento dati non corretto");
            return null;
        }

        if (libro.getAnnoPubblicazione() <= 0) {
            System.out.println("L'anno di pubblicazione deve essere un numero positivo");
            return null;
        }

        if (libro.getQuantitaDisponibile() < 0) {
            System.out.println("La quantita` disponibile non puo` essere negativa");
            return null;
        }
        if (lr.modifica(id, libro) != null) {
            System.out.println("Libro modificato, ecco i dettagli:");
        } else {
            return null;
        }
        return lr.modifica(id, libro);
    }

    public void eliminaLibro(Long id) {
        lr.elimina(id);
    }

    public void impostaQuantitaDisponibile(Long id, int quantita) {
        if (lr.mostraSingolo(id) != null) {
            lr.mostraSingolo(id).setQuantitaDisponibile(quantita);
        }
        System.out.println("Libro con seguente id non trovato");
        return;
    }

    public Collection<Libro> mostraTutti() {
        return lr.mostraTutti();
    }

    public Libro mostraLibro(Long id) {
        if (lr.mostraSingolo(id) != null) {
            System.out.println("Libro trovato, ecco i dettagli:");
        } else {
            return null;
        }
        return lr.mostraSingolo(id);
    }
}