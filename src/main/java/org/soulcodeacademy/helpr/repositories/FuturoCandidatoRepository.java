package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.enums.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuturoCandidatoRepository extends JpaRepository<FuturoCandidato, Integer> {

    List<FuturoCandidato> findByEmailCandidato(String emailCandidato);
    List<FuturoCandidato> findByNomeCompletoContaining(String nomeCompleto);
    List<FuturoCandidato> findBySetor(Setor setor);
}
