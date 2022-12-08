package org.soulcodeacademy.helpr.controllers;


import org.soulcodeacademy.helpr.domain.Dependente;
import org.soulcodeacademy.helpr.domain.dto.DependenteDTO;
import org.soulcodeacademy.helpr.services.DependenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
public class DependenteController {

    @Autowired
    private DependenteService dependenteService;



    @GetMapping("/dependentes")
    public List<Dependente> listarDependentes(){
        return this.dependenteService.listarTodos();
    }

    @GetMapping("/dependentes/{idDependente}")
    public Dependente getDependente(@PathVariable Integer idDependente){
        return this.dependenteService.getDependente(idDependente);
    }


    @GetMapping("/dependentes/cpf/{cpf}")
    public Dependente getDependente(@PathVariable String cpf){
        return this.dependenteService.getDependentePorCpf(cpf);
    }

    @GetMapping("/dependentes/faixa/{data1}/{data2}")
    public List<Dependente> filtarEntreDatas(@PathVariable String data1, @PathVariable String data2){
        LocalDate inicio = LocalDate.parse(data1);
        LocalDate fim = LocalDate.parse(data2);
        return this.dependenteService.filtrarEntreDatas(inicio, fim);
    }

    @PostMapping("/dependentes")
    public Dependente salvar(@Valid @RequestBody DependenteDTO dto){
        return this.dependenteService.salvar(dto);
    }


    @PutMapping("/dependentes/{idDependente}")
    public Dependente atualizar(@PathVariable Integer idDependente, @Valid @RequestBody DependenteDTO dto){
        return this.dependenteService.atualizar(idDependente, dto);
    }

    @DeleteMapping("/dependentes/{idDependente}")
    public void deletar(@PathVariable Integer idDependente){
        this.dependenteService.deletar(idDependente);
    }


    @GetMapping("/dependentes/funcionarios/{idFuncionario}")
    public List<Dependente> listarDependentesDoResponsavel(@PathVariable Integer idFuncionario){
        return this.dependenteService.listarDependetesDoFuncionario(idFuncionario);
    }


}
