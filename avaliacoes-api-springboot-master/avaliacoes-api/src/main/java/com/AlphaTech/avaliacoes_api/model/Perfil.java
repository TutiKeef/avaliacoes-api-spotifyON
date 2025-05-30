package com.AlphaTech.avaliacoes_api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Perfil_table")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private Long celphone;

    @ManyToMany
    @JsonIgnoreProperties("amigos") // Evita loop infinito ao serializar
    private List<Perfil> amigos = new ArrayList<>();

    public Perfil() {
    }

    public Perfil(String nome, Long id, String email, Long celphone) {
        this.nome = nome;
        this.id = id;
        this.email = email;
        this.celphone = celphone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCelphone() {
        return celphone;
    }

    public void setCelphone(Long celphone) {
        this.celphone = celphone;
    }

    public List<Perfil> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Perfil> amigos) {
        this.amigos = amigos;
    }

    public void adicionarAmigo(Perfil amigo) {
        if (!amigos.contains(amigo)) {
            amigos.add(amigo);
        }
    }

    public void removerAmigo(Perfil amigo) {
        amigos.remove(amigo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Perfil)) return false;
        Perfil perfil = (Perfil) o;
        return Objects.equals(id, perfil.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


