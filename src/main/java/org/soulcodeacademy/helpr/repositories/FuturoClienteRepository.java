package org.soulcodeacademy.helpr.repositories;


import org.soulcodeacademy.helpr.domain.FuturoCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FuturoClienteRepository extends JpaRepository<FuturoCliente, Integer> {

   Optional<FuturoCliente> findByEmail(String email);
   Optional<FuturoCliente> findByCpf(String cpf);
}
