package com.example.demo.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Cliente;
import com.example.demo.Entity.Ordine;
import com.example.demo.Entity.Servizio;
import com.example.demo.Repository.ClienteRepository;
import com.example.demo.Repository.OrdineRepository;
import com.example.demo.Repository.ServizioRepository;

@Service
public class OrdineService {

    @Autowired
    OrdineRepository ordineRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ServizioRepository servizioRepository;

    public Ordine mostraOrdine(Long id) {
        Ordine ordine = ordineRepository.findById(id).orElse(null);
        if (ordine == null) {
            return null;
        }
        return ordine;
    }

    public Ordine aggiungiNuovoOrdine(Long clienteId, List<Long> serviziScelti) {
        // trovo il cliente in base all'id
        Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
        if (cliente == null) {
            return null;
        }

        // Trovo i servizi in base all'id
        List<Servizio> servizi = servizioRepository.findAllById(serviziScelti);

        // per il calcolo del costo totale sommo il costo dei singoli servizi
        // selezionati

        double costoTotale = 0;
        for (Servizio servizio : servizi) {
            costoTotale += servizio.getCosto();
        }

        // creo l'istanza dell'ordine
        Ordine ordine = new Ordine();
        ordine.setCostoTotale(costoTotale);
        ordine.setCliente(cliente);
        ordine.setServizi(servizi);
        ordine.setDataConsegna(LocalDate.now());
        ordine.setDataRitiro(ordine.getDataConsegna().plusDays(3));
        return ordineRepository.save(ordine);
    }

    public List<Ordine> mostraTutti() {
        return ordineRepository.findAll();
    }

    public void eliminaOrdine(Long id) {
        ordineRepository.deleteById(id);
    }

    public Ordine modifiaCOrdine(Long idOrdine, Long idCliente, List<Long> serviziScelti) {
        // verifico se l'ordine esiste
        Ordine ordine = ordineRepository.findById(idOrdine).orElse(null);
        if (ordine == null) {
            return null;
        }

        // verifico se il cliente esiste
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
        if (cliente == null) {
            return null;
        }

        // Cerco i servizi in base all'id e li metto in una lista
        List<Servizio> servizi = servizioRepository.findAllById(serviziScelti);

        double costoTotale = 0;
        for (Servizio servizio : servizi) {
            costoTotale += servizio.getCosto();
        }

        // Adesso posso aggiornare i dati dell'ordine
        ordine.setCliente(cliente);
        ordine.setCostoTotale(costoTotale);
        ordine.setDataConsegna(LocalDate.now());
        ordine.setDataRitiro(ordine.getDataConsegna().plusDays(3));
        ordine.setServizi(servizi);

        // salvo l'ordine
        return ordineRepository.save(ordine);
    }
}
