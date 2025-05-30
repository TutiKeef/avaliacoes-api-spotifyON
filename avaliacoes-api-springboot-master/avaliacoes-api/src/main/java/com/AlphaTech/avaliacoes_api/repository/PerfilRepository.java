package com.AlphaTech.avaliacoes_api.repository;

import com.AlphaTech.avaliacoes_api.model.Perfil;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface PerfilRepository extends JpaRepository <Perfil, Long> {
}
