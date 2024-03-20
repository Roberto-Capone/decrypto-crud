package com.capone.decrypto.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capone.decrypto.entity.Mercado;

public interface MercadoRepository extends JpaRepository<Mercado, Integer> {

}
