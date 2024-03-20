package com.capone.decrypto.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Version;

@Entity(name = "comitente")
public class Comitente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Version
    private long version;

    private String descripcion;

    @ManyToMany(mappedBy = "comitentes")
    private Set<Mercado> mercados;

    public Comitente() {

    }

    public Comitente(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Mercado> getMercados() {
        return mercados;
    }

    @Override
    public String toString() {
        return """
                   Comitente{
                       id = %d,
                       descripcion = '%s'
                   }
               """.formatted(id, descripcion);
    }
}
