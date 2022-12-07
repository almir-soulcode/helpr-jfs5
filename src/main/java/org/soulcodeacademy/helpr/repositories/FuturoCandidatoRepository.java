package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.enums.SetorFuturoCandidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuturoCandidatoRepository extends JpaRepository<FuturoCandidato, Integer> {

    // Filtrar por email;
    List<FuturoCandidato> findByEmail(String email);

    // Buscar pelo nome (containing);
    List<FuturoCandidato> findByNomeCompletoContaining(String busca);

    // Filtrar pelo setor.
    List<FuturoCandidato> findBySetor(SetorFuturoCandidato setor);
}
