package com.capone.decrypto.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;

@Entity(name = "mercado")
public class Mercado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Version
    private long version;

    private String codigo;

    private String descripcion;

    @ManyToOne
    private Pais pais;

    @ManyToMany
    @JoinTable(
            name = "comitente_mercado",
            joinColumns = @JoinColumn(name = "mercado_id"),
            inverseJoinColumns = @JoinColumn(name = "comitente_id")
    )
    private Set<Comitente> comitentes;

    public Mercado() {

    }

    public Mercado(Integer id, String codigo, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Set<Comitente> getComitentes() {
        return comitentes;
    }

    @Override
    public String toString() {
        return """
                   Mercado{
                       id = %d,
                       codigo = '%s',
                       descripcion = '%s'
                   }
               """.formatted(id, codigo, descripcion);
    }
}
