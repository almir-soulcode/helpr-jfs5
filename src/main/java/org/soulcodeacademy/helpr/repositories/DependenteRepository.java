package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Dependente;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Integer> {
    //Filtrar os dependentes por date between;
    //Filtrar por CPF;
    //Filtrar por escolaridade;
    //Filtrar por responsável;

    Optional<Dependente> findByCpf(String cpf); // WHERE cpf = cpf

    List<Dependente> findByEscolaridade(String escolaridade);

    List<Dependente> findByResponsavel(Funcionario responsavel);

    @Query(value = "SELECT * FROM dependente WHERE data_nasc BETWEEN :data1 AND :data2", nativeQuery = true)
    List<Dependente> buscarEntreDatas(LocalDate data1, LocalDate data2);
}
