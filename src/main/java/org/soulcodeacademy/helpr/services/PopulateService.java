package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.Chamado;
import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.enums.Perfil;
import org.soulcodeacademy.helpr.domain.enums.StatusChamado;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.soulcodeacademy.helpr.repositories.ChamadoRepository;
import org.soulcodeacademy.helpr.repositories.ClienteRepository;
import org.soulcodeacademy.helpr.repositories.FuncionarioRepository;
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
        Funcionario f3 = new Funcionario(null, "Rodrigo Santoro", "rodrigopereira@gmail.com", "36259874152", encoder.encode("12345"), null, c2);
        f3.setPerfil(Perfil.ADMIN);
        Funcionario f4 = new Funcionario(null, "Miriam Rios", "miriam.rios@gmail.com", "96852301475", encoder.encode("12345"), null, c2);
        f4.setPerfil(Perfil.ADMIN);
        Funcionario f5 = new Funcionario(null, "Daniel Azulai Pereira", "daniel.azulai@gmail.com", "96325632963", encoder.encode("12345"), null, c2);
        f5.setPerfil(Perfil.ADMIN);
        Funcionario f6 = new Funcionario(null, "Mauricio de Souza", "mauriciodesouzaa@gmail.com", "74269854785", encoder.encode("12345"), null, c3);
        f6.setPerfil(Perfil.ADMIN);
        Funcionario f7 = new Funcionario(null, "Tarcisio Meira", "tarmeira@gmail.com", "96785412302", encoder.encode("12345"), null, c3);
        Funcionario f8 = new Funcionario(null, "Regina Duarte", "regina.duarte@gmail.com", "01269874521", encoder.encode("12345"), null, c3);
        Funcionario f9 = new Funcionario(null, "Gloria Pires", "gloriapiresa@gmail.com", "02369785412", encoder.encode("12345"), null, c3);

        Cliente cl1 = new Cliente(null, "José Almir", "jose.almir@gmail.com", "12659185115", encoder.encode("batata"), "9999999999");
        Cliente cl2 = new Cliente(null, "Pedro João", "pedro@gmail.com", "37734168302", encoder.encode("batata"), "9999999997");
        Cliente cl3 = new Cliente(null, "Paola de Oliveira", "paolaoliveira@gmail.com", "98547863215", encoder.encode("12345"), "9999999996");
        Cliente cl4 = new Cliente(null, "Gusttavo Lima", "gustavo.lima@gmail.com", "02368102456", encoder.encode("12345"), "9999999995");

        Chamado ch1 = new Chamado(null, "Primeiro chamado do sistema", "Revisar as entidades criadas");
        ch1.setCliente(cl1);
        Chamado ch2 = new Chamado(null, "Ativar VPN do sistema", "Conectar aos servidores remotos");
        ch2.setCliente(cl2);
        ch2.setFuncionario(f1);
        ch2.setStatus(StatusChamado.ATRIBUIDO);
        Chamado ch3 = new Chamado(null, "Conectar internet", "Trocar cabos de rede");
        ch3.setCliente(cl3);
        ch3.setFuncionario(f5);
        ch3.setStatus(StatusChamado.RECEBIDO);
        Chamado ch4 = new Chamado(null, "Trocar roteadores", "Configurar roteadores");
        ch4.setCliente(cl4);
        ch4.setFuncionario(f6);
        ch4.setStatus(StatusChamado.RECEBIDO);
        Chamado ch5 = new Chamado(null, "Conectar internet", "Trocar cabos de rede");
        ch5.setCliente(cl2);
        ch5.setFuncionario(f7);
        ch5.setStatus(StatusChamado.CONCLUIDO);
        Chamado ch6 = new Chamado(null, "Ativar VPN do sistema", "Conectar aos servidores remotos");
        ch6.setCliente(cl1);
        ch6.setFuncionario(f8);
        ch6.setStatus(StatusChamado.CONCLUIDO);
        Chamado ch7 = new Chamado(null, "Trocar roteadores", "Configurar roteadores");
        ch7.setCliente(cl4);
        ch7.setFuncionario(f9);
        ch7.setStatus(StatusChamado.CONCLUIDO);


        // vamos persistir as entidades = salvar no banco
        this.cargoRepository.saveAll(List.of(c1, c2, c3));
        this.funcionarioRepository.saveAll(List.of(f1, f2, f3, f4, f5, f6, f7, f8, f9));
        this.clienteRepository.saveAll(List.of(cl1, cl2, cl3, cl4));
        this.chamadoRepository.saveAll(List.of(ch1, ch2, ch3, ch4, ch5, ch6, ch7));
    }
}

// O objetivo desta classe é inserir no banco, dados fictícios (de teste)
// IOC = Inversion of Control = Inversão de Controle = É ele quem manda nas instâncias
// Container = é o local onde o Spring guarda os objetos anotados
// @Service = indica que a classe é um serviço
// Injeção de Dependências = quando o Spring injeta os objetos na classe