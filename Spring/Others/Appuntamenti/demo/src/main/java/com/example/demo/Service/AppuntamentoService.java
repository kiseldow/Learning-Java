package com.example.demo.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.Appuntamento;

@Service
public class AppuntamentoService {

    private final Map<Long, Appuntamento> appuntamenti = new HashMap<>();
    private Long currentId = 1L;

    public Appuntamento aggiungiAppuntamento(Appuntamento appuntamento) {
        appuntamento.setId(currentId++);
        appuntamenti.put(appuntamento.getId(), appuntamento);
        return appuntamento;
    }

    public Appuntamento ottieniPerId(Long id) {
        return appuntamenti.get(id);

    }

    public Collection<Appuntamento> ottieniTutti() {
        return appuntamenti.values();
    }

    public Appuntamento aggiornaAppuntamento(Long id, Appuntamento appuntamento) {
        if (appuntamenti.containsKey(id)) {
            appuntamento.setId(id);
            appuntamenti.put(id, appuntamento);
            return appuntamento;
        }
        return null;
    }

    public void eliminaAppuntamento(Long id) {
        appuntamenti.remove(id);
    }
}
