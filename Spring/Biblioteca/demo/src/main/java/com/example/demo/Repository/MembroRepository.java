package com.example.demo.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.Membro;

@Repository
public class MembroRepository {

    private Map<Long, Membro> membri = new HashMap<>();
    private Long currentId = 1L;

    public Membro aggiungi(Membro membro) {
        membro.setId(currentId++);
        membri.put(membro.getId(), membro);
        return membro;
    }

    public Collection<Membro> mostraTutti() {
        return membri.values();
    }

    public Membro mostraSingolo(Long id) {
        return membri.get(id);
    }

    public void elimina(Long id) {
        membri.remove(id);
    }

    public Membro modifica(Long id, Membro membro) {
        if (membri.containsKey(id)) {
            membro.setId(id);
            membri.put(id, membro);
            return membro;
        }
        return null;
    }

}
