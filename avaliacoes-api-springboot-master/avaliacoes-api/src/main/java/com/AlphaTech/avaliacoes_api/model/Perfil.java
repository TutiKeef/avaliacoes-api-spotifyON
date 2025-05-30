package com.AlphaTech.avaliacoes_api.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Perfil_table")
public class Perfil {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
private String Email;
private Long Celphone;

    @ManyToMany
    private List<Perfil> amigos = new ArrayList<>();


    public Perfil(String name, Long id, String email, Long Celphone) {
        this.name = name;
        this.id = id;
        Email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Long getCelphone() {
        return Celphone;
    }

    public void setCelphone(Long celphone) {
        Celphone = celphone;
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


