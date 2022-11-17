package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Chamado;
import org.soulcodeacademy.helpr.domain.dto.ChamadoDTO;
import org.soulcodeacademy.helpr.services.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ChamadoController {
    @Autowired
    private ChamadoService chamadoService;

    @GetMapping("/chamados")
    public List<Chamado> listarChamados() {
        return this.chamadoService.listarChamados();
    }

    @GetMapping("/chamados/{idChamado}")
    public Chamado getChamado(@PathVariable Integer idChamado) {
        return this.chamadoService.getChamado(idChamado);
    }

    @PostMapping("/chamados")
    public Chamado salvar(@Valid @RequestBody ChamadoDTO dto) {
        return this.chamadoService.salvar(dto);
    }

    @PutMapping("/chamados/{idChamado}")
    public Chamado atualizar(@PathVariable Integer idChamado, @Valid @RequestBody ChamadoDTO dto) {
        return this.chamadoService.atualizar(idChamado, dto);
    }
}
