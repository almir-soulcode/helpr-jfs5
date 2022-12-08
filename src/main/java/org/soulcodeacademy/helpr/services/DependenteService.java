package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Dependente;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.dto.DependenteDTO;
import org.soulcodeacademy.helpr.repositories.DependenteRepository;
import org.soulcodeacademy.helpr.services.errors.ParametrosInsuficientesError;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DependenteService {


    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
    private FuncionarioService funcionarioService;

    public List<Dependente> listarTodos(){
        return this.dependenteRepository.findAll();
    }


    public Dependente getDependente(Integer idDependente){
        return this.dependenteRepository.findById(idDependente)
                .orElseThrow(() -> new RecursoNaoEncontradoError("Dependente não encontrado"));

    }

    public Dependente getDependentePorCpf(String cpf){
        return this.dependenteRepository.findByCpf(cpf)
                .orElseThrow(() -> new RecursoNaoEncontradoError("Dependente não encontrado"));
    }


    public List<Dependente> filtrarEntreDatas(LocalDate inicio, LocalDate fim){
        List<Dependente> dependentes = this.dependenteRepository.buscarEntreDatas(inicio, fim);
        if (dependentes.isEmpty()){
            throw new RecursoNaoEncontradoError("Não existe dependentes cadastrados nessas faixas");
        }
        return dependentes;
    }


    public Dependente salvar(DependenteDTO dto){

        Integer idade = (LocalDate.now().minusDays(dto.getDataNasc().getDayOfMonth())
                .minusMonths(dto.getDataNasc().getMonthValue()).minusYears(dto.getDataNasc().getYear())).getYear();
        if (idade >= 18){
            throw new ParametrosInsuficientesError("O dependente é maior de idade");
        }

        Funcionario responsavel = this.funcionarioService.getFuncionario(dto.getIdResponsavel());
        Dependente dependente = new Dependente(null, dto.getNome(), dto.getCpf(), dto.getDataNasc(), dto.getEscolaridade());
        dependente.setResponsavel(responsavel);

        return this.dependenteRepository.save(dependente);
    }

    public Dependente atualizar(Integer idDependente, DependenteDTO dto){
        Dependente dependente = this.getDependente(idDependente);
        dependente.setNome(dto.getNome());
        dependente.setCpf(dto.getCpf());
        dependente.setDataNasc(dto.getDataNasc());
        dependente.setEscolaridade(dto.getEscolaridade());
        //Atualizar dependente (não permitir mudar de responsável);
        dependente.setResponsavel(dependente.getResponsavel());
        return this.dependenteRepository.save(dependente);
    }


    public void deletar(Integer idDepedente){
        Dependente dependente = this.getDependente(idDepedente);
        this.dependenteRepository.delete(dependente);
    }

    public List<Dependente> listarDependetesDoFuncionario(Integer idFuncionario){
        Funcionario responsavel = this.funcionarioService.getFuncionario(idFuncionario);
        List<Dependente> dependentes = this.dependenteRepository.findByResponsavel(responsavel);
        if (dependentes.isEmpty()){
            throw new RecursoNaoEncontradoError("Este funcionário não possui dependentes");
        }
        return dependentes;
    }



}
