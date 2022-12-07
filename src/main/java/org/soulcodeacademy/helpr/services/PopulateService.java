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
        f2.setPerfil(Perfil.FUNCIONARIO);

        Funcionario adm2 = new Funcionario(null, "Rafael Nunes", "rafadevxp@gmail.com", "025914666023", encoder.encode("rafael1"), null, c1);
        adm2.setPerfil(Perfil.ADMIN);
        // Integer id, String nome, String email, String cpf, String senha, String telefone

        Funcionario adm3 = new Funcionario(null, "Rafaela Nunes", "rafaeladev@gmail.com", "77822186086", encoder.encode("rafaela"), null, c1);
        adm3.setPerfil(Perfil.ADMIN);

        Funcionario adm4 = new Funcionario(null, "Robert Santos", "robertsantos@gmail.com", "99876755534", encoder.encode("devutil"), null, c1);
        adm4.setPerfil(Perfil.ADMIN);

        Funcionario adm5 = new Funcionario(null, "Lucas Nunes", "lucasxp@gmail.com", "0986756634", encoder.encode("123456"), null, c1);
        adm5.setPerfil(Perfil.ADMIN);

        Funcionario adm6 = new Funcionario(null, "Manoelly", "manu@gmail.com", "07078755534", encoder.encode("manuzinha"), null, c1);
        adm6.setPerfil(Perfil.ADMIN);

        Funcionario f4 = new Funcionario(null, "Luiza Roberta", "luludev@gmail.com", "79097620031", encoder.encode("luisadev"), null, c3);
        f4.setPerfil(Perfil.FUNCIONARIO);

        Funcionario f5 = new Funcionario(null, " Roberta", "roberta@gmail.com", "51613132000", encoder.encode("robertadev"), null, c3);
        f5.setPerfil(Perfil.FUNCIONARIO);

        Funcionario f6 = new Funcionario(null, "Carlos Nobrega", "carlinhos@gmail.com", "76951584028", encoder.encode("54321"), null, c2);
        f6.setPerfil(Perfil.FUNCIONARIO);



        Cliente cl1 = new Cliente(null, "José Almir", "jose.almir@gmail.com", "89059217012", encoder.encode("batata"), "9999999999");

        Cliente cl2 = new Cliente(null, "Pedro João", "pedro@gmail.com", "72674057033", encoder.encode("batatafrita"), "9999999997");
       cl2.setPerfil(Perfil.CLIENTE);
        Cliente cl3 = new Cliente(null, "Pedro Sampaio", "pedrosmp@gmail.com", "40725624086", encoder.encode("batata123"), "9999239997");
        cl3.setPerfil(Perfil.CLIENTE);
        Cliente cl4 = new Cliente(null, "Pedro lucas", "pedrolls@gmail.com", "46947681073", encoder.encode("batata321"), "9999789997");
        cl4.setPerfil(Perfil.CLIENTE);

        Chamado ch1 = new Chamado(null, "Primeiro chamado do sistema", "Revisar as entidades criadas");
        ch1.setCliente(cl1);
        ch1.setStatus(StatusChamado.RECEBIDO);
        Chamado ch2 = new Chamado(null, "Ativar VPN do sistema", "Conectar aos servidores remotos");
        ch2.setCliente(cl2);
        ch2.setFuncionario(f1);
        ch2.setStatus(StatusChamado.ATRIBUIDO);

        Chamado ch3 = new Chamado(null, "Terceiro chamado do Sistema", "Descrição teste");
        ch3.setCliente(cl3);
        ch3.setFuncionario(f4);
        ch3.setStatus(StatusChamado.RECEBIDO);

        Chamado ch4 = new Chamado(null, "Ativar  proteção do sistema", "Ativar Segurança de senha");
        ch4.setCliente(cl4);
        ch4.setFuncionario(f5);
        ch4.setStatus(StatusChamado.CONCLUIDO);

        Chamado ch5 = new Chamado(null, "Quinto chamado do sistema", "Quinto  servidores remotos");
        ch5.setCliente(cl1);
        ch5.setFuncionario(f6);
        ch5.setStatus(StatusChamado.RECEBIDO);

        Chamado ch6 = new Chamado(null, "Sexto chamado do sistema", "Teste descrição");
        ch6.setCliente(cl2);
        ch6.setFuncionario(adm5);
        ch6.setStatus(StatusChamado.CONCLUIDO);

        Chamado ch7 = new Chamado(null, "Ativar ROOT do sistema", "Conectar aos servidores remotos");
        ch7.setCliente(cl4);
        ch7.setFuncionario(adm4);
        ch7.setStatus(StatusChamado.RECEBIDO);


        // vamos persistir as entidades = salvar no banco
        this.cargoRepository.saveAll(List.of(c1, c2, c3));
        this.funcionarioRepository.saveAll(List.of(f1, f2,f4,f5,f6,adm3,adm2,adm4,adm5,adm6));
        this.clienteRepository.saveAll(List.of(cl1, cl2,cl3,cl4));
        this.chamadoRepository.saveAll(List.of(ch1, ch2,ch3,ch4,ch5,ch6,ch7));
    }
}

// O objetivo desta classe é inserir no banco, dados fictícios (de teste)
// IOC = Inversion of Control = Inversão de Controle = É ele quem manda nas instâncias
// Container = é o local onde o Spring guarda os objetos anotados
// @Service = indica que a classe é um serviço
// Injeção de Dependências = quando o Spring injeta os objetos na classe