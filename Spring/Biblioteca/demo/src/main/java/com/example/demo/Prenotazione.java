package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

public class Prenotazione {
    private Long id;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    @Autowired
    private Libro libro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataInizio) {
        this.dataFine = dataInizio.plusDays(3);
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

}
