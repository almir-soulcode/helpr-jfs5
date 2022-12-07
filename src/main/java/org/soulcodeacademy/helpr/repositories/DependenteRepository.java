package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Chamado;
import org.soulcodeacademy.helpr.domain.Dependente;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Integer> {
List<Dependente> findBycpf(String cpf);
List<Dependente> findByEscolaridade(String escolaridade);
List<Dependente> findByFuncionario(Funcionario funcionario);
    @Query(value = "SELECT * FROM chamado WHERE data_abertura BETWEEN :data1 AND :data2", nativeQuery = true)
    List<Dependente> buscarEntreDatas(Date data1, Date data2);
}
