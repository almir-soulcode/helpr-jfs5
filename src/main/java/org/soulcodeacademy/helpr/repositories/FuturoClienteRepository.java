package org.soulcodeacademy.helpr.repositories;

import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.FuturoCliente;
import org.soulcodeacademy.helpr.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuturoClienteRepository extends JpaRepository<FuturoCliente, Integer> {
    Optional<Usuario> findByEmail(String email); // WHERE email = email
    Optional<Usuario> findByCpf(String cpf); // WHERE cpf = cpf

}
