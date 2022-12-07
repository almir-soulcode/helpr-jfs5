package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuturoCandidatoRepository extends JpaRepository<FuturoCandidato, Integer> {

    Optional<FuturoCandidato> findByEmail(String email); // where email = ?

    Optional<FuturoCandidato> findByNomeContaining(String nome); // where funcionario.nome like ?1

    Optional<FuturoCandidato> findBySetor(String setor); // where setor = ?

}
