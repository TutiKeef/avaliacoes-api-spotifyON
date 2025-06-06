package com.AlphaTech.avaliacoes_api.repository;

import com.AlphaTech.avaliacoes_api.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    List<Perfil> findByNomeContaining(String nome);
}