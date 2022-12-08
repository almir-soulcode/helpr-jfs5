package org.soulcodeacademy.helpr.controllers;

import org.soulcodeacademy.helpr.domain.Dependente;
import org.soulcodeacademy.helpr.domain.dto.DependenteDTO;
import org.soulcodeacademy.helpr.services.DependenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DependenteController {

    @Autowired
    private DependenteService dependenteService;

    @GetMapping("/dependentes")
    public List<Dependente> listar()
    {
        return  this.dependenteService.listar();
    }

    @GetMapping("/dependentes/{idDependente}")
    public Dependente getDependente(@PathVariable Integer idDependente){
        return  this.dependenteService.getDependente(idDependente);
    }

    @PostMapping("/dependentes")
    public Dependente salvar(@Valid @RequestBody DependenteDTO dto){
        return this.dependenteService.salvar(dto);
    }

    @PutMapping("/dependentes/{idDependente}")
    public  Dependente atualizar (@PathVariable Integer idDependente, @Valid @RequestBody DependenteDTO dto){
        return this.dependenteService.atualizar(idDependente,dto);
    }

    @DeleteMapping("/dependentes/{idDependente}")
    public  void  deletar (@PathVariable Integer idDependente){
        this.dependenteService.deletar(idDependente);
    }

    @GetMapping("/dependentes/cpf/{cpf}")
    public Dependente filtrarCpf(@PathVariable String cpf){
        return this.dependenteService.filtrarCpf(cpf);
    }

    @GetMapping("/dependentes/faixa/{date1}/{date2}")
    public  List<Dependente> filtrarData(@PathVariable String date1, String date2){
        return this.dependenteService.filtrarData(date1,date2);
    }

    @GetMapping("/dependentes/funcionarios/{idFuncionario}")
    public List<Dependente> filtrarResponsavel(@PathVariable Integer idFuncionario){
        return this.dependenteService.filtrarResponsavel(idFuncionario);
    }


}
