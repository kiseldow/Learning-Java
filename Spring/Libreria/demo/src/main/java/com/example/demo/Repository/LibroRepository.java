package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
