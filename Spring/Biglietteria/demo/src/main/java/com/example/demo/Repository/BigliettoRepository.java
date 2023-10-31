package com.example.demo.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.demo.Biglietto;

public class BigliettoRepository {

    private Map<Long, Biglietto> biglietti = new HashMap<>();
    private Long currentId = 1L;

    private ArrayList<Biglietto> concerti = new ArrayList<Biglietto>();
    private ArrayList<Biglietto> cinema = new ArrayList<Biglietto>();
    private ArrayList<Biglietto> teatro = new ArrayList<Biglietto>();

    public Biglietto aggiungiBiglietto(Biglietto biglietto) {

        if (biglietto.getNomeEvento().equals("concerto")) {
            concerti.add(biglietto);
        } else if (biglietto.getNomeEvento().equals("cinema")) {
            cinema.add(biglietto);
        } else if (biglietto.getNomeEvento().equals("teatro")) {
            teatro.add(biglietto);
        }
        biglietto.setId(currentId++);
        biglietti.put(biglietto.getId(), biglietto);
        return biglietto;

    }

    // METODI CONCERTI, CINEMA E TEATRO

    public Collection<Biglietto> getAllConcert() {
        return concerti;
    }

    public Collection<Biglietto> getAllCinema() {
        return cinema;
    }

    public Collection<Biglietto> getAllTeatro() {
        return teatro;
    }

    public Biglietto cercaPerId(Long id) {
        return biglietti.get(id);
    }

    public void elimina(Long id) {
        biglietti.remove(id);
    }

    public Collection<Biglietto> mostraTutti() {
        return biglietti.values();
    }

    public Biglietto aggiorna(Long id, Biglietto biglietto) {
        if (biglietti.containsKey(id)) {
            biglietto.setId(id);
            biglietti.put(id, biglietto);
            return biglietto;
        }
        return null;
    }
}
