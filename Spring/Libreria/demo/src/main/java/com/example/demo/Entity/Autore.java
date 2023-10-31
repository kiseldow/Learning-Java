package com.example.demo.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Autore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany(targetEntity = Autore.class)
    @JoinTable(name = "autore-libro", joinColumns = @JoinColumn(name = "autore_id"), inverseJoinColumns = @JoinColumn(name = "libro_id"))
    private Set<Libro> libri = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Libro> getLibri() {
        return libri;
    }

    public void setLibri(Libro libro) {
        libri.add(libro);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
