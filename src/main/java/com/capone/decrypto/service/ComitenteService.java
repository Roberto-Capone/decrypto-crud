package com.capone.decrypto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;

import com.capone.decrypto.entity.Comitente;
import com.capone.decrypto.persistence.ComitenteRepository;

import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ComitenteService {

    @Autowired
    private ComitenteRepository repository;

    @Lock(LockModeType.WRITE)
    public Comitente create(Comitente comitente) {
        return repository.save(comitente);
    }

    @Lock(LockModeType.READ)
    public List<Comitente> retrieveAll() {
        return repository.findAll();
    }

    @Lock(LockModeType.READ)
    public Optional<Comitente> retrieveById(Integer id) {
        return repository.findById(id);
    }

    @Lock(LockModeType.WRITE)
    public Comitente update(Comitente updated, Integer id) {
        Comitente outdated = repository.findById(id).get();
        outdated.setDescripcion(updated.getDescripcion());
        return repository.save(outdated);
    }

    @Lock(LockModeType.WRITE)
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
