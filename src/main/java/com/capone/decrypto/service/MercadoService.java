package com.capone.decrypto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;

import com.capone.decrypto.entity.Mercado;
import com.capone.decrypto.persistence.MercadoRepository;

import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class MercadoService {

    @Autowired
    private MercadoRepository repository;

    @Lock(LockModeType.WRITE)
    public Mercado create(Mercado mercado) {
        return repository.save(mercado);
    }

    public List<Mercado> retrieveAll() {
        return repository.findAll();
    }

    public Optional<Mercado> retrieveById(Integer id) {
        return repository.findById(id);
    }

    @Lock(LockModeType.WRITE)
    public Mercado update(Mercado updated, Integer id) {
        Mercado outdated = repository.findById(id).get();
        outdated.setDescripcion(updated.getDescripcion());
        outdated.setCodigo(updated.getCodigo());

        return repository.save(outdated);
    }

    @Lock(LockModeType.WRITE)
    public void delete(int id) {
        repository.deleteById(id);
    }
}
