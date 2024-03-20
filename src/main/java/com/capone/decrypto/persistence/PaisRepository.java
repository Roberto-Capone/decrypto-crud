package com.capone.decrypto.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capone.decrypto.entity.Pais;

public interface PaisRepository extends JpaRepository<Pais, Integer> {

}
