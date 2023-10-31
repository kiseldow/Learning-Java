package com.example.demo.Service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.demo.Biglietto;
import com.example.demo.Repository.BigliettoRepository;

@Service
public class BigliettoService {

    private BigliettoRepository br = new BigliettoRepository();

    public Collection<Biglietto> getAll() {
        return br.mostraTutti();
    }

    public Biglietto getBiglietto(Long id) {
        return br.cercaPerId(id);
    }

    public Biglietto addBiglietto(Biglietto biglietto) {
        return br.aggiungiBiglietto(biglietto);
    }

    public void deleteBiglietto(Long id) {
        br.elimina(id);
    }

    public Biglietto updateBiglietto(Biglietto biglietto, Long id) {
        return br.aggiorna(id, biglietto);
    }

    public Biglietto aggiorna(Long id, Biglietto biglietto) {
        return br.aggiorna(id, biglietto);
    }

    public Collection<Biglietto> getAllConcert() {
        return br.getAllConcert();
    }

    public Collection<Biglietto> getAllCinema() {
        return br.getAllCinema();
    }

    public Collection<Biglietto> getAllTeatro() {
        return br.getAllTeatro();
    }

}