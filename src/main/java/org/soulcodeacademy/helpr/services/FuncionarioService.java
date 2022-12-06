package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.dto.FuncionarioDTO;
import org.soulcodeacademy.helpr.repositories.FuncionarioRepository;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // instanciar automaticamente minha classe
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CargoService cargoService;

    public List<Funcionario> listar() {
        return this.funcionarioRepository.findAll();
    }

    public List<Funcionario> listarPorFaixaSalarial(Double valor1, Double valor2) {
        return this.funcionarioRepository.findBySalarioEntreFaixas(valor1, valor2);
    }

    public Funcionario getFuncionario(Integer idFuncionario) {
        // Optional = pode existir ou não a entidade
        return  this.funcionarioRepository.findById(idFuncionario)
                .orElseThrow(() -> new RecursoNaoEncontradoError ("Funcionário não encontrado"));
    }

    public Funcionario salvar(FuncionarioDTO dto) {
        Cargo cargo = this.cargoService.getCargo(dto.getIdCargo()); // verifica se o cargo existe mesmo
        // id, nome, email,cpf, String senha, foto, cargo
        // Transferindo informações do DTO para nossa entidade
        Funcionario funcionario = new Funcionario(null, dto.getNome(), dto.getEmail(), dto.getCpf(), dto.getSenha(), dto.getFoto(), cargo);
        Funcionario salvo = this.funcionarioRepository.save(funcionario);

        return salvo;
    }

    public Funcionario atualizar(Integer idFuncionario, FuncionarioDTO dto) {
        // Busca o funcionario com o idFuncionario
        Funcionario funcionarioAtual = this.getFuncionario(idFuncionario);
        // Busca os dados do cargo a ser alterado
        Cargo cargo = this.cargoService.getCargo(dto.getIdCargo());

        funcionarioAtual.setNome(dto.getNome());
        funcionarioAtual.setEmail(dto.getEmail());
        funcionarioAtual.setCpf(dto.getCpf());
        funcionarioAtual.setSenha(dto.getSenha());
        funcionarioAtual.setFoto(dto.getFoto());
        funcionarioAtual.setCargo(cargo);

        Funcionario atualizado = this.funcionarioRepository.save(funcionarioAtual);
        return atualizado;
    }

    public void deletar(Integer idFuncionario) {
        Funcionario funcionario = this.getFuncionario(idFuncionario);
        this.funcionarioRepository.delete(funcionario);
    }
}
