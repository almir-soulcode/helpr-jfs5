package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Dependente;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.dto.DependenteDTO;
import org.soulcodeacademy.helpr.repositories.DependenteRepository;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class DependenteService {
@Autowired
    public DependenteRepository dependenteRepository;
@Autowired
    public  FuncionarioService funcionarioService ;

    public List<Dependente> listar() {
        return  this.dependenteRepository.findAll();
    }

    public Dependente getDependente(Integer idDependendte){
        return this.dependenteRepository.findById(idDependendte)
                .orElseThrow(() -> new RecursoNaoEncontradoError("Dependente não encontrado!"));
    }

    public  Dependente salvar (DependenteDTO dto){
        Funcionario funcionario = this.funcionarioService.getFuncionario(dto.getIdFuncionario());

        long years = ChronoUnit.YEARS.between(dto.getDataDeNascimento(), LocalDate.now());

        if (years < 18){
            Dependente dependente = new Dependente(null, dto.getNome(), dto.getCpf(), dto.getDataDeNascimento(), dto.getEscolaridade(), funcionario);

            return  this.dependenteRepository.save(dependente);
        } else  {
            throw new RecursoNaoEncontradoError(" Acima de  18 anos");
        }
    }

    public Dependente atualizar( Integer idDependente, DependenteDTO dto) {
        Dependente dependente = this.getDependente(idDependente);

        if (dependente.getFuncionario() == this.funcionarioService.getFuncionario(dto.getIdFuncionario())){

            dependente.setNome(dto.getNome());
            dependente.setDataDeNascimento(dto.getDataDeNascimento());
            dependente.setCpf(dto.getCpf());
            dependente.setEscolaridade(dto.getEscolaridade());


            return this.dependenteRepository.save(dependente);
        } else {
            throw new RecursoNaoEncontradoError("Não foi possivel alterar  o responsável");
        }
     }

     public void  deletar(Integer idDependente) {
        Dependente dependente = this.getDependente(idDependente);
        this.dependenteRepository.delete(dependente);
     }

        public Dependente filtrarCpf(String cpf) {

        return  this.dependenteRepository.findByCpf(cpf).orElseThrow(
                () -> new RecursoNaoEncontradoError("Dependente não encontrado")
        );
        }

    public List<Dependente> filtrarData(String valor1, String valor2){

        LocalDate v1 = LocalDate.parse(valor1);
        LocalDate v2 = LocalDate.parse(valor2);
        return this.dependenteRepository.findByDataEntreFaixas(v1, v2);
    }

    public List<Dependente> filtrarResponsavel(Integer idFuncionario){

        Funcionario funcionario = this.funcionarioService.getFuncionario(idFuncionario);

        return this.dependenteRepository.findByFuncionario(funcionario);
    }
    }


