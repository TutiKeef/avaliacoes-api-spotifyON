package com.AlphaTech.avaliacoes_api.controller;

import com.AlphaTech.avaliacoes_api.model.Perfil;
import com.AlphaTech.avaliacoes_api.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    private final PerfilService perfilService;

    @Autowired
    public PerfilController(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    @GetMapping
    public List<Perfil> getAll() {
        return perfilService.getAll();
    }

    @PostMapping
    public Perfil create(@RequestBody Perfil perfil) {
        return perfilService.save(perfil);
    }


    @PutMapping("/{id}/adicionar-amigo/{amigoId}")
    public ResponseEntity<Perfil> adicionarAmigo(@PathVariable Long id, @PathVariable Long amigoId) {
        Perfil perfilAtualizado = perfilService.adicionarAmigo(id, amigoId);
        return ResponseEntity.ok(perfilAtualizado);
    }


    @PutMapping("/{id}/remover-amigo/{amigoId}")
    public ResponseEntity<Perfil> removerAmigo(@PathVariable Long id, @PathVariable Long amigoId) {
        Perfil perfilAtualizado = perfilService.removerAmigo(id, amigoId);
        return ResponseEntity.ok(perfilAtualizado);
    }
}
