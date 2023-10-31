package com.example.demo;

import java.time.LocalDateTime;

public class Appuntamento {
    private Long id;
    private LocalDateTime dataEora;
    private String nomeCliente;
    private String descrizione;

    public void setId(Long long1) {
        this.id = long1;
    }

    public Long getId() {
        return id;
    }
}
