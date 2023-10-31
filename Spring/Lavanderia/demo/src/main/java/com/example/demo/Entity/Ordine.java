package com.example.demo.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordine")
public class Ordine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataConsegna;
    private LocalDate dataRitiro;
    private double costoTotale;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(name = "ordine_servizio", joinColumns = @JoinColumn(name = "ordine_id"), inverseJoinColumns = @JoinColumn(name = "servizio_id"))
    private List<Servizio> servizi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataConsegna() {
        return dataConsegna;
    }

    public void setDataConsegna(LocalDate dataConsegna) {
        this.dataConsegna = dataConsegna;
    }

    public LocalDate getDataRitiro() {
        return dataRitiro;
    }

    public void setDataRitiro(LocalDate dataRitiro) {
        this.dataRitiro = dataRitiro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Servizio> getServizi() {
        return servizi;
    }

    public void setServizi(List<Servizio> servizi) {
        this.servizi = servizi;
    }

    public double getCostoTotale() {
        return costoTotale;
    }

    public void setCostoTotale(double costoTotale) {
        this.costoTotale = costoTotale;
    }

}
