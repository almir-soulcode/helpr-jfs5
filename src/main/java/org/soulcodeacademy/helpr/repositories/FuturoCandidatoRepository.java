package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FuturoCandidatoRepository extends JpaRepository<FuturoCandidato, Integer> {

    List<FuturoCandidato> findBySetor(String setor);

    List<FuturoCandidato> findByEmail(String email);

    List<FuturoCandidato> findByNome(String nome);





}



