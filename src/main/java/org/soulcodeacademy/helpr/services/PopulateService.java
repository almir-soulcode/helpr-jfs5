package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.*;
import org.soulcodeacademy.helpr.domain.enums.Perfil;
import org.soulcodeacademy.helpr.domain.enums.Setor;
import org.soulcodeacademy.helpr.domain.enums.StatusChamado;
import org.soulcodeacademy.helpr.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private FuturoClienteRepository futuroClienteRepository;

    @Autowired
    private FuturoCandidatoRepository futuroCandidatoRepository;
    
    @Autowired
    private DependenteRepository dependenteRepository;


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

        Cliente cl1 = new Cliente(null, "José Almir", "jose.almir@gmail.com", "12659185115", encoder.encode("batata"), "9999999999");
        Cliente cl2 = new Cliente(null, "Pedro João", "pedro@gmail.com", "37734168302", encoder.encode("batata"), "9999999997");

        Chamado ch1 = new Chamado(null, "Primeiro chamado do sistema", "Revisar as entidades criadas");
        ch1.setCliente(cl1);
        Chamado ch2 = new Chamado(null, "Ativar VPN do sistema", "Conectar aos servidores remotos");
        ch2.setCliente(cl2);
        ch2.setFuncionario(f1);
        ch2.setStatus(StatusChamado.ATRIBUIDO);

        // vamos persistir as entidades = salvar no banco
        this.cargoRepository.saveAll(List.of(c1, c2, c3));
        this.funcionarioRepository.saveAll(List.of(f1, f2));
        this.clienteRepository.saveAll(List.of(cl1, cl2));
        this.chamadoRepository.saveAll(List.of(ch1, ch2));

        // Dados do futuro cliente
        FuturoCliente futuroCliente1 = new FuturoCliente(null, "Pedro Oliveira", "(11) 99943-3234", "pedro@gmail.com", "384.738.590-90");
        FuturoCliente futuroCliente2 = new FuturoCliente(null, "Luiz Souza", "(11) 94323-2345", "luiz@gmail.com", "316.883.580-30");
        this.futuroClienteRepository.save(futuroCliente1);
        this.futuroClienteRepository.save(futuroCliente2);

        // Realizando a query

        Optional<Integer> limite = this.chamadoRepository.quantidadeDeChamados(f1.getId());

        System.out.println(limite.get());


        // Dados do futuroCandidato
        FuturoCandidato futuroCandidato1 = new FuturoCandidato(null, "André Pereira", "andre@gmail.com", "Executa grandes projetos com eficiência e eficácia!", Setor.DESENVOLVIMENTO);
        FuturoCandidato futuroCandidato2 = new FuturoCandidato(null, "Jhonatan Oliveira", "jhonatan@gmail.com", "Criativo e organizado", Setor.MARKETING);
        this.futuroCandidatoRepository.save(futuroCandidato1);
        this.futuroCandidatoRepository.save(futuroCandidato2);

        List<FuturoCandidato> futuroCandidato3 = this.futuroCandidatoRepository.findByEmail("andre@gmail.com");
        System.out.println(futuroCandidato3.toString());

        List<FuturoCandidato> futuroCandidato4 = this.futuroCandidatoRepository.findByNomeCompletoContaining("Oliveira");
        System.out.println(futuroCandidato4.toString());

        // Dados de Dependente Teste
        //Nome;
        //CPF;
        //Data de Nascimento;
        //Escolaridade;
        Dependente dependente1 = new Dependente(null,"Bianca Torres","123.123.123-33", LocalDate.of(2002,12,12), "Ensino Médio");
        dependente1.setResponsavel(f1); //Antes de salvar, utiliza-se o método set para associar dependente a funcionário
        this.dependenteRepository.save(dependente1);

        Dependente dependente2 = new Dependente(null,"Amanda Aparecida","080.123.123-24", LocalDate.of(2010,01,12), "Ensino Fundamental");
        dependente2.setResponsavel(f1); //Antes de salvar, utiliza-se o método set para associar dependente a funcionário
        this.dependenteRepository.save(dependente2);

        //Dependente dependente = this.dependenteRepository.findByCpf("123.123.123-00")
        //        .orElseThrow(()-> new RuntimeException("CPF não encontrado!")); //Optional

        //System.out.println(dependente.toString());

       //List<Dependente> dependentes = this.dependenteRepository.findByEscolaridade("Ensino Fundamental");
        //System.out.println(dependentes.toString()); //List

        //List<Dependente> dependentesDoResponsavel = this.dependenteRepository.findByResponsavel(f1);
        //.out.println(dependentesDoResponsavel.toString());

       LocalDate data1= LocalDate.of(1999,11,21);
        LocalDate data2= LocalDate.of(2013,11,21);

       List<Dependente> buscarEntreDatas= this.dependenteRepository.buscarEntreDatas(data1, data2);
        if (buscarEntreDatas.isEmpty()) {
            throw new RuntimeException("Não existe depentes neste intervalo de datas!");
        }
        System.out.println(buscarEntreDatas.toString());

    }
}


// O objetivo desta classe é inserir no banco, dados fictícios (de teste)
// IOC = Inversion of Control = Inversão de Controle = É ele quem manda nas instâncias
// Container = é o local onde o Spring guarda os objetos anotados
// @Service = indica que a classe é um serviço
// Injeção de Dependências = quando o Spring injeta os objetos na classe