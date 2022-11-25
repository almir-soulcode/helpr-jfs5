package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.dto.CargoDTO;
import org.soulcodeacademy.helpr.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController // retornos de dados
public class CargoController {

    // Endpoint é o endereço que será acessado no backend
    @GetMapping("/oi") // com base em localhost:8080/oi retorna a String
    public String dizOla() {
        return "Olá, tudo bem?"; // resposta da requisição
    }

    @GetMapping("/batata")
    public Integer valor() {
        return 1000; // resposta da requisição
    }

    @Autowired
    private CargoService cargoService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_FUNCIONARIO')") // Admin e funcionario podem acessar
    @GetMapping("/cargos")
    public List<Cargo> listar() {
        // Requisição -> Controller -> Service -> Repository -> SELECT * FROM cargo;
        return this.cargoService.listar(); // JSON = JAVASCRIPT OBJECT NOTATION
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_FUNCIONARIO')")
    @GetMapping("/cargos/{idCargo}") // indica que o valor após a barra é dinâmico!
    public Cargo getCargo(@PathVariable Integer idCargo) {
        // @PathVariable => extrai do endpoint o valor dinâmico
        return this.cargoService.getCargo(idCargo);
    }

    // Podemos usar o mesmo endpoint para verbos diferentes
    @PreAuthorize("hasRole('ROLE_ADMIN')") // Apenas os admins podem acessar este endpoint
    @PostMapping("/cargos") // REQUISIÇÃO TIPO POST para /cargos
    public Cargo salvar(@Valid @RequestBody CargoDTO cargo) {
        // @RequestBody - extrair o JSON do corpo e converte para Cargo (deserialização)
        Cargo salvo = this.cargoService.salvar(cargo);
        return salvo; // A resposta será o cargo inserido
    }

    // Mapeia requisições do verbo PUT
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/cargos/{idCargo}") // /cargos/5
    public Cargo atualizar(@PathVariable Integer idCargo, @Valid @RequestBody CargoDTO cargo) {
       Cargo atualizado = this.cargoService.atualizar(idCargo, cargo);
       return atualizado; // Resposta para o cliente (cargo atualizado)
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/cargos/{idCargo}") // Verbo DELETE no /cargos/1
    public void deletar(@PathVariable Integer idCargo) {
        this.cargoService.deletar(idCargo);
    }
}
