package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Dependente;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


//Filtrar os dependentes por data between;
//Filtrar por CPF;
//Filtrar por escolaridade;
//Filtrar por responsável;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Integer> {

    @Query(value = "SELECT * FROM dependente WHERE data_abertura BETWEEN :data1 AND :data2", nativeQuery = true)
    List<Dependente> findByDataEntreFaixas(LocalDate data1, LocalDate data2);

    List<Dependente> findByCpf(String cpf);

    List<Dependente> findByescolaridade(String escolaridade);


    List<Dependente> findByFuncionario(Funcionario funcionario);
}