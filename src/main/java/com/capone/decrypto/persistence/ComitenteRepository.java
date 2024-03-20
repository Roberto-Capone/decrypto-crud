package com.capone.decrypto.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capone.decrypto.entity.Comitente;

public interface ComitenteRepository extends JpaRepository<Comitente, Integer> {

}
