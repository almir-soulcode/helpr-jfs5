package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.enums.Setor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuturoCandidatoRepository extends JpaRepository<FuturoCandidato, Integer> {

    List<FuturoCandidato> findByEmail(String email);

    List<FuturoCandidato> findByNomeContaining (String nome);

    List<FuturoCandidato> findBySetorContaining (Setor setor);


}
