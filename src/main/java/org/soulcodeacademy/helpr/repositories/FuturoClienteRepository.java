package org.soulcodeacademy.helpr.repositories;


import org.soulcodeacademy.helpr.domain.FuturoCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FuturoClienteRepository extends JpaRepository<FuturoCliente, Integer> {

    List<FuturoCliente> findByCpf(String cpf);

    List<FuturoCliente> findByEmail(String email);

}
