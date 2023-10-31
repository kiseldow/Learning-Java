package com.example.demo.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Membro;
import com.example.demo.Repository.MembroRepository;

@Service
public class MembroService {
    @Autowired
    MembroRepository mr;

    public Membro aggiungiMembro(Membro membro) {
        if (membro.getCognome().isEmpty() ||
                membro.getNome().isEmpty() ||
                membro.getNome().isEmpty()) {
            System.out.println("Inserimento dati non corretto");
            return null;
        }
        return mr.aggiungi(membro);
    }

    public Membro modificaLibro(Long id, Membro membro) {
        if (membro.getCognome().isEmpty() ||
                membro.getEmail().isEmpty() ||
                membro.getEmail().isEmpty()) {
            System.out.println("Inserimento dati non corretto");
            return null;
        }

        if (mr.modifica(id, membro) != null) {
            System.out.println("membro modificato, ecco i dettagli:");
        } else {
            return null;
        }
        return mr.modifica(id, membro);
    }

    public void eliminaMembro(Long id) {
        mr.elimina(id);
    }

    public Membro mostraMembro(Long id) { // That s what she said
        if (mr.mostraSingolo(id) != null) {
            System.out.println("membro trovato, ecco i dettagli:");
        } else {
            return null;
        }
        return mr.mostraSingolo(id);
    }

    public Collection<Membro> mostraTutti() {
        return mr.mostraTutti();
    }

}
