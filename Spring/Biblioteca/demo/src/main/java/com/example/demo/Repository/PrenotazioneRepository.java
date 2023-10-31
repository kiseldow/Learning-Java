package com.example.demo.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.Libro;
import com.example.demo.Prenotazione;

@Repository
public class PrenotazioneRepository {

    private Map<Long, Prenotazione> prenotazioni = new HashMap<>();
    private Long currentId = 1L;

    public Prenotazione aggiungi(Prenotazione prenotazione) {
        prenotazione.setId(currentId++);
        prenotazioni.put(prenotazione.getId(), prenotazione);
        return prenotazione;
    }

    public Collection<Prenotazione> mostraTutti() {
        return prenotazioni.values();
    }

    public Prenotazione mostraSingolo(Long id) {
        return prenotazioni.get(id);
    }

    public void elimina(Long id) {
        prenotazioni.remove(id);
    }

    public Prenotazione modifica(Long id, LocalDate newData, Libro libro) {
        if (prenotazioni.containsKey(id)) {
            Prenotazione prenotazione = prenotazioni.get(id);
            prenotazione.setId(id);
            prenotazione.setDataInizio(newData);
            prenotazione.setDataInizio(newData);
            prenotazione.setLibro(libro);
            prenotazioni.put(id, prenotazione);
            return prenotazione;
        }
        return null;
    }

}
