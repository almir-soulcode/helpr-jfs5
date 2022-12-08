package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Chamado;
import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.dto.ChamadoDTO;
import org.soulcodeacademy.helpr.domain.enums.StatusChamado;
import org.soulcodeacademy.helpr.repositories.ChamadoRepository;
import org.soulcodeacademy.helpr.services.errors.ParametrosInsuficientesError;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ChamadoService {
    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private FuncionarioService funcionarioService;

    public List<Chamado> listarChamados() {
        return this.chamadoRepository.findAll();
    }

    public Chamado getChamado(Integer idChamado) {
        // Caso não encontre o chamado, lança a exceção.
        return this.chamadoRepository.findById(idChamado)
                .orElseThrow(() -> new RecursoNaoEncontradoError("Chamado não encontrado"));
    }

    public Chamado salvar(ChamadoDTO dto) {
        // Verificar se existe um cliente com este ID
        Cliente cliente = this.clienteService.getCliente(dto.getIdCliente());
        Chamado chamado = new Chamado(null, dto.getTitulo(), dto.getDescricao());
        chamado.setCliente(cliente); // associa o cliente ao chamado

        return this.chamadoRepository.save(chamado);
    }

    public Chamado atualizar(Integer idChamado, ChamadoDTO dto) {

        Chamado chamadoAtual = this.getChamado(idChamado);

        Cliente cliente = this.clienteService.getCliente(dto.getIdCliente());

            switch (dto.getStatus()) { // Escolha o valor de getStatus()
                case RECEBIDO -> {
                    chamadoAtual.setStatus(StatusChamado.RECEBIDO);
                    chamadoAtual.setFuncionario(null);
                    chamadoAtual.setDataFechamento(null);
                    chamadoAtual.setTitulo(dto.getTitulo());
                    chamadoAtual.setDescricao(dto.getDescricao());
                    chamadoAtual.setCliente(cliente);
                }
                case ATRIBUIDO -> {
                    if (dto.getIdFuncionario() == null) {
                        throw new ParametrosInsuficientesError("idFuncionario obrigatório");
                    } else {
                        Funcionario funcionario = this.funcionarioService.getFuncionario(dto.getIdFuncionario());
                        chamadoAtual.setStatus(StatusChamado.ATRIBUIDO);
                        chamadoAtual.setFuncionario(funcionario);
                        chamadoAtual.setDataFechamento(null);
                        chamadoAtual.setTitulo(dto.getTitulo());
                        chamadoAtual.setDescricao(dto.getDescricao());
                        chamadoAtual.setCliente(cliente);
                    }
                }
                case CONCLUIDO -> {
                    if (dto.getIdFuncionario() == null) {
                        throw new ParametrosInsuficientesError("idFuncionario obrigatório");
                    } else {
                        Funcionario funcionario = this.funcionarioService.getFuncionario(dto.getIdFuncionario());
                        chamadoAtual.setStatus(StatusChamado.CONCLUIDO);
                        chamadoAtual.setFuncionario(funcionario);
                        chamadoAtual.setDataFechamento(LocalDate.now());
                        chamadoAtual.setTitulo(dto.getTitulo());
                        chamadoAtual.setDescricao(dto.getDescricao());
                        chamadoAtual.setCliente(cliente);
                    }
                }
                case ARQUIVADO -> {
                    if (dto.getIdFuncionario() == null) {
                        throw new ParametrosInsuficientesError("idFuncionario obrigatório");
                    } else {
                        Funcionario funcionario = this.funcionarioService.getFuncionario(dto.getIdFuncionario());
                        chamadoAtual.setStatus(StatusChamado.ARQUIVADO);
                        chamadoAtual.setFuncionario(funcionario);
                        chamadoAtual.setDataFechamento(null);
                    }
                }
            }

        return this.chamadoRepository.save(chamadoAtual);
    }

    public List<Chamado> listarPorStatus(StatusChamado status) {
        return this.chamadoRepository.findByStatus(status);
    }

    public List<Chamado> listarPorFuncionario(Integer idFuncionario) {
        Funcionario funcionario = this.funcionarioService.getFuncionario(idFuncionario);
        return this.chamadoRepository.findByFuncionario(funcionario);
    }

    public List<Chamado> listarPorCliente(Integer idCliente) {
        Cliente cliente = this.clienteService.getCliente(idCliente);
        return this.chamadoRepository.findByCliente(cliente);
    }

    public List<Chamado> listarPorIntervaloDatas(LocalDate data1, LocalDate data2) {
        return this.chamadoRepository.buscarEntreDatas(data1, data2);
    }
}
