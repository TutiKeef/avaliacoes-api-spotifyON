package com.AlphaTech.avaliacoes_api.service;

import com.AlphaTech.avaliacoes_api.model.Perfil;
import com.AlphaTech.avaliacoes_api.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public List<Perfil> getAll() {
        return perfilRepository.findAll();
    }

    public Perfil save(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    public void delete(Long id) {
        perfilRepository.deleteById(id);
    }

    public Perfil adicionarAmigo(Long idPerfil, Long idAmigo) {
        Perfil perfil = buscarOuFalhar(idPerfil);
        Perfil amigo = buscarOuFalhar(idAmigo);

        perfil.adicionarAmigo(amigo);
        return perfilRepository.save(perfil);
    }

    public Perfil removerAmigo(Long idPerfil, Long idAmigo) {
        Perfil perfil = buscarOuFalhar(idPerfil);
        Perfil amigo = buscarOuFalhar(idAmigo);

        perfil.removerAmigo(amigo);
        return perfilRepository.save(perfil);
    }

    private Perfil buscarOuFalhar(Long id) {
        return perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil com ID " + id + " não encontrado"));
    }
}
