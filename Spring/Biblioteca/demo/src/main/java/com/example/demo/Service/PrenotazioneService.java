package com.example.demo.Service;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Libro;
import com.example.demo.Membro;
import com.example.demo.Prenotazione;
import com.example.demo.Repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {
    @Autowired
    PrenotazioneRepository pr;
    @Autowired
    LibroService ls;
    @Autowired
    MembroService ms;

    public Prenotazione CercaPrenotazione(Long id) {
        if (pr.mostraSingolo(id) == null) {
            System.out.println("Id prenotazione non trovata");
            return null;
        }
        return pr.mostraSingolo(id);
    }

    public Prenotazione aggiungiPrenotazione(Long idMembro, LocalDate dataInizio, Long idLibro) {
        Membro membro = ms.mostraMembro(idMembro);
        Libro libro = ls.mostraLibro(idLibro);

        if (membro == null) {
            System.out.println("Membro non trovato");
            return null;
        }

        if (libro == null) {
            System.out.println("Libro non trovato");
            return null;
        }

        if (dataInizio.isBefore(LocalDate.now())) {
            System.out.println("Data inserita non valida");
            return null;
        }

        if (membro.getPrenotazioni().size() >= 3) {
            System.out.println("Membro " + membro.getNome() + " ha già 3 prenotazioni");
            return null;
        }

        if (libro.getQuantitaDisponibile() <= 0) {
            System.out.println("Quantità non disponibile per il libro");
            return null;
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDataInizio(dataInizio);
        prenotazione.setDataFine(dataInizio.plusDays(3));
        prenotazione.setLibro(libro);

        membro.getPrenotazioni().add(prenotazione);
        libro.setQuantitaDisponibile(libro.getQuantitaDisponibile() - 1);

        pr.aggiungi(prenotazione);

        System.out.println("Prenotazione aggiunta con successo");
        return prenotazione;
    }

    public Prenotazione modificPrenotazione(Long id, LocalDate dataInizio, Long idLibro) {
        if (dataInizio.isBefore(LocalDate.now())) {
            System.out.println("Data inserita non valida");
            return null;
        }
        if (ls.mostraLibro(idLibro) == null) {
            System.out.println("Id libro non trovato");
            return null;
        }
        System.out.println("Prenotazione modificata con successo. Dettagli:");
        return pr.modifica(idLibro, dataInizio, ls.mostraLibro(idLibro));
    }

    public void eliminaPrenotazione(Long id) {
        if (pr.mostraSingolo(id) == null) {
            System.out.println("Id prenotazione non trovata");
            return;
        }
        pr.elimina(id);
    }

    public Collection<Prenotazione> ottieniPrenotazioni() {
        return pr.mostraTutti();
    }

}
