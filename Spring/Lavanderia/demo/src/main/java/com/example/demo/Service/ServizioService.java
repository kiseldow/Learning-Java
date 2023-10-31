package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Servizio;
import com.example.demo.Repository.ServizioRepository;

@Service
public class ServizioService {

    @Autowired
    ServizioRepository servizioRepository;

    public Servizio mostraServizio(Long id) {
        Servizio servizio = servizioRepository.findById(id).orElse(null);
        if (servizio == null) {
            return null;
        }
        return servizio;
    }

    public Servizio aggiungiServizio(Servizio servizio) {
        return servizioRepository.save(servizio);
    }

    public List<Servizio> mostraTutti() {
        return servizioRepository.findAll();
    }

    public void eliminaServizio(Long id) {
        servizioRepository.deleteById(id);
    }

    public Servizio modificaServizio(Long id, String tipo, double costo, int tempoEsecuzione) {
        Servizio servizio = servizioRepository.findById(id).orElse(null);
        if (servizio == null) {
            return null;
        }

        servizio.setCosto(costo);
        servizio.setTempoEsecuzione(tempoEsecuzione);
        servizio.setTipo(tipo);
        return servizio;
    }
}
