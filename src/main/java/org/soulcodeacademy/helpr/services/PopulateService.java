package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.*;
import org.soulcodeacademy.helpr.domain.enums.Perfil;
import org.soulcodeacademy.helpr.domain.enums.StatusChamado;
import org.soulcodeacademy.helpr.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

// Torna o objeto de PopulateService disponível para toda a aplicação (global)
@Service // indica para o Spring que esta classe será gerenciada por ele
public class PopulateService {
    @Autowired // injetar o objeto direto na classe
    private CargoRepository cargoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private PasswordEncoder encoder;

    public void populate() {
        // Integer idCargo, String nome, String descricao, Double salario
        Cargo c1 = new Cargo(null, "Diretor Geral", "Gerencia a empresa", 30000.0);
        Cargo c2 = new Cargo(null, "Diretor de Setor", "Gerencia um setor da empresa", 18000.0);
        Cargo c3 = new Cargo(null, "Técnico geral", "Resolve os chamados urgentes", 12000.0);

        // Integer id, String nome, String email, String cpf, String senha, String foto, Cargo cargo
        Funcionario f1 = new Funcionario(null, "Renato Pereira", "renato.pereira@gmail.com", "68258098144", encoder.encode("12345"), null, c1);
        f1.setPerfil(Perfil.ADMIN);
        Funcionario f2 = new Funcionario(null, "Victor Icoma", "victor.icoma@gmail.com", "51127383671", encoder.encode("12345"), null, c2);
        // Integer id, String nome, String email, String cpf, String senha, String telefone

        Funcionario f3 = new Funcionario(null, "Paula Araujo", "paula.araujo@gmail.com", "13887360044", encoder.encode("12345"), null, c3);
        Funcionario f4 = new Funcionario(null, "Sabrina Silva", "ss@gmail.com", "10050748017", encoder.encode("12345"), null, c3);
        Funcionario f5 = new Funcionario(null, "Talita Santana", "talitastn@gmail.com", "02468379004", encoder.encode("12345"), null, c3);

        Funcionario f6 = new Funcionario(null, "Beatriz Souza", "souzabea@gmail.com", "85369886067", encoder.encode("12345"), null, c2);
        f6.setPerfil(Perfil.ADMIN);
        Funcionario f7 = new Funcionario(null, "Rodrigo Clemente", "rodrigoc@gmail.com", "56588170050", encoder.encode("12345"), null, c2);
        f7.setPerfil(Perfil.ADMIN);
        Funcionario f8 = new Funcionario(null, "Mirelli Rodrigues", "mirirod@gmail.com", "15385332003", encoder.encode("12345"), null, c2);
        f8.setPerfil(Perfil.ADMIN);
        Funcionario f9 = new Funcionario(null, "Daniel Victor", "danivicto@gmail.com", "87018128072", encoder.encode("12345"), null, c2);
        f9.setPerfil(Perfil.ADMIN);
        Funcionario f10 = new Funcionario(null, "Alba Regina ", "albagigi@gmail.com", "27397853056", encoder.encode("12345"), null, c2);
        f10.setPerfil(Perfil.ADMIN);


        Cliente cl1 = new Cliente(null, "José Almir", "jose.almir@gmail.com", "12659185115", encoder.encode("batata"), "9999999999");
        Cliente cl2 = new Cliente(null, "Pedro João", "pedro@gmail.com", "37734168302", encoder.encode("batata"), "9999999997");

        Cliente cl3 = new Cliente(null, "João Augusto", "joao@gmail.com", "60855332093", encoder.encode("batata"), "9999999996");
        Cliente cl4 = new Cliente(null, "Lucia Maria", "lmaria@gmail.com", "53812036088", encoder.encode("batata"), "9999999995");

        Chamado ch1 = new Chamado(null, "Primeiro chamado do sistema", "Revisar as entidades criadas");
        ch1.setCliente(cl1);
        Chamado ch2 = new Chamado(null, "Ativar VPN do sistema", "Conectar aos servidores remotos");

        Chamado ch3 = new Chamado(null, "Instalar pacotes", "Baixar e instalar o pacotes");
        Chamado ch4 = new Chamado(null, "Trocar periféricos", "Trocar e instalar teclado e mouse");
        Chamado ch5 = new Chamado(null, "Instação de Software específico", "Installar IntelliJ");
        Chamado ch6 = new Chamado(null, "Formatação","Formatar note" );
        Chamado ch7 = new Chamado(null, "Cabeamento","instalação de cabos de internet");


        ch2.setCliente(cl2);
        ch2.setFuncionario(f1);
        ch2.setStatus(StatusChamado.ATRIBUIDO);
        ch3.setCliente(cl1);
        ch3.setFuncionario(f2);
        ch3.setStatus(StatusChamado.RECEBIDO);

        ch4.setCliente(cl3);
        ch4.setFuncionario(f4);
        ch4.setStatus((StatusChamado.RECEBIDO) );

        ch3.setCliente(cl4);
        ch3.setFuncionario(f3);
        ch3.setStatus((StatusChamado.RECEBIDO) );

        ch4.setCliente(cl4);
        ch4.setFuncionario(f6);
        ch4.setStatus((StatusChamado.RECEBIDO) );

        ch5.setCliente(cl4);
        ch5.setFuncionario(f6);
        ch5.setStatus(StatusChamado.CONCLUIDO);

        ch6.setCliente(cl1);
        ch6.setFuncionario(f10);
        ch6.setStatus(StatusChamado.CONCLUIDO);






        // vamos persistir as entidades = salvar no banco
        this.cargoRepository.saveAll(List.of(c1, c2, c3));
        this.funcionarioRepository.saveAll(List.of(f1, f2));
        this.clienteRepository.saveAll(List.of(cl1, cl2));
        this.chamadoRepository.saveAll(List.of(ch1, ch2));


    }
}

// O objetivo desta classe é inserir no banco, dados fictícios (de teste)
// IOC = Inversion of Control = Inversão de Controle = É ele quem manda nas instâncias
// Container = é o local onde o Spring guarda os objetos anotados
// @Service = indica que a classe é um serviço
// Injeção de Dependências = quando o Spring injeta os objetos na classe