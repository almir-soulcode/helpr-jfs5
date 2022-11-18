package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Chamado;
import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.enums.StatusChamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {
    List<Chamado> findByStatus(StatusChamado status); // Filtrar os chamados de acordo com o status
    List<Chamado> findByCliente(Cliente cliente); // Filtrar os chamados de um cliente
    List<Chamado> findByFuncionario(Funcionario funcionario); // Filtrar os chamados de um funcionario

    // nativeQuery = ativa a sintaxe do SQL
    @Query(value = "SELECT * FROM chamado WHERE data_abertura BETWEEN :data1 AND :data2", nativeQuery = true)
    List<Chamado> buscarEntreDatas(LocalDate data1, LocalDate data2);
}
