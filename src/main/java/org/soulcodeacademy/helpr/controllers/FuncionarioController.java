package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.dto.FuncionarioDTO;
import org.soulcodeacademy.helpr.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController // esta classe é capaz de captar as requisições
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    // /funcionarios (GET)
    @GetMapping("/funcionarios")
    public List<Funcionario> listar() {
        return this.funcionarioService.listar();
    }

    // /funcionarios/{id} (GET)
    @GetMapping("/funcionarios/{idFuncionario}")
    public Funcionario getFuncionario(@PathVariable Integer idFuncionario) {
        return this.funcionarioService.getFuncionario(idFuncionario);
    }

    // POST = Representa inserção de dados
    @PostMapping("/funcionarios")
    public Funcionario salvar(@Valid @RequestBody FuncionarioDTO dto) {
        Funcionario funcionario = this.funcionarioService.salvar(dto);
        return funcionario;
    }

    // PUT = Representa substituição de dados
    @PutMapping("/funcionarios/{idFuncionario}")
    public Funcionario atualizar(@PathVariable Integer idFuncionario, @Valid @RequestBody FuncionarioDTO dto) {
        Funcionario atualizado = this.funcionarioService.atualizar(idFuncionario, dto);
        return atualizado;
    }

    @DeleteMapping("/funcionarios/{idFuncionario}")
    public void deletar(@PathVariable Integer idFuncionario) {
        this.funcionarioService.deletar(idFuncionario);
    }
}
