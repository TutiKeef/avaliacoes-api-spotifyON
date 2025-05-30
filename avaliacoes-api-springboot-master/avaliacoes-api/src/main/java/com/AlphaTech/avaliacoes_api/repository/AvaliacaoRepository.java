package com.AlphaTech.avaliacoes_api.repository;

import com.AlphaTech.avaliacoes_api.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    //buscar avaliações por perfil
    List<Avaliacao> findByPerfilId(Long perfilId);

    //buscar todas as avaliações para um álbum específico do Spotify
    List<Avaliacao> findBySpotifyAlbumId(String spotifyAlbumId);
}