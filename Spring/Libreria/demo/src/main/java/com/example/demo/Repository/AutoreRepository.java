package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Autore;

public interface AutoreRepository extends JpaRepository<Autore, Long> {

}
