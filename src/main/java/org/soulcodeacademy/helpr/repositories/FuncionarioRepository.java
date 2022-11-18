package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> { // Generics
    List<Funcionario> findByCargo(Cargo cargo); // Filtrar os funcionarios que possuem o cargo

    List<Funcionario> findByFotoIsNull(); // Filtrar funcionario sem foto definida

    List<Funcionario> findByFotoIsNotNull(); // Filtrar os funcionario com foto definida

    @Query(value = "SELECT * FROM usuarios INNER JOIN cargo ON usuarios.id_cargo = cargo.id_cargo WHERE dtype = 'Funcionario' AND cargo.salario BETWEEN :valor1 AND :valor2", nativeQuery = true)
    List<Funcionario> findBySalarioEntreFaixas(Double valor1, Double valor2);
}
