package org.soulcodeacademy.helpr.domain;

import org.soulcodeacademy.helpr.domain.enums.StatusChamado;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idChamado;

    @Column(nullable = false, length = 120)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    private LocalDate dataAbertura = LocalDate.now();

    private LocalDate dataFechamento;

    @Enumerated(EnumType.STRING) // representando o enum "escrito"
    private StatusChamado status = StatusChamado.RECEBIDO;

    @ManyToOne // MUITOS CHAMADOS P/ UM FUNCIONÁRIO
    @JoinColumn(name = "id_funcionario") // FOREIGN KEY (id_funcionario) REFERENCES funcionario(id_funcionario)
    private Funcionario funcionario;

    @ManyToOne // MUITOS CHAMADOS P/ UM CLIENTE
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    public Chamado() {
    }

    public Chamado(Integer idChamado, String titulo, String descricao) {
        this.idChamado = idChamado;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Integer getIdChamado() {
        return idChamado;
    }

    public void setIdChamado(Integer idChamado) {
        this.idChamado = idChamado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public StatusChamado getStatus() {
        return status;
    }

    public void setStatus(StatusChamado status) {
        this.status = status;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
