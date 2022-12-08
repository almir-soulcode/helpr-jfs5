
package org.soulcodeacademy.helpr.services;
import org.soulcodeacademy.helpr.domain.FuturoCliente;
import org.soulcodeacademy.helpr.domain.dto.FuturoClienteDTO;
import org.soulcodeacademy.helpr.repositories.FuturoClienteRepository;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class FuturoClienteService {

    @Autowired
    private FuturoClienteRepository futuroClienteRepository;


    public List<FuturoCliente> listarTodos() {
        return this.futuroClienteRepository.findAll();
    }

    public FuturoCliente getFuturoCliente(Integer idFuturoCliente) {
        return this.futuroClienteRepository.findById(idFuturoCliente)
                .orElseThrow(() -> new RecursoNaoEncontradoError("Futuro cliente não encontrado"));
    }


    public FuturoCliente buscarPorCpf (String cpf) {
        return this.futuroClienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new RecursoNaoEncontradoError("Futuro cliente não encontrado"));
    }


    public FuturoCliente buscarPorEmail (String email) {
        return this.futuroClienteRepository.findByEmail(email)
                .orElseThrow(() -> new RecursoNaoEncontradoError("Futuro cliente não encontrado"));
    }


    public FuturoCliente salvar(FuturoClienteDTO dto) {
        FuturoCliente futuroCliente = new FuturoCliente(null, dto.getNome(), dto.getTelefone(), dto.getCpf(), dto.getEmail());
        FuturoCliente salvo = this.futuroClienteRepository.save(futuroCliente);
        return salvo;
    }


    public FuturoCliente atualizar(Integer idFuturoCliente, FuturoClienteDTO dto){
        FuturoCliente futuroCliente = this.getFuturoCliente(idFuturoCliente);
        futuroCliente.setNome(dto.getNome());
        futuroCliente.setCpf(dto.getCpf());
        futuroCliente.setEmail(dto.getEmail());
        futuroCliente.setTelefone(dto.getTelefone());

        return this.futuroClienteRepository.save(futuroCliente);

    }


    public void deletar(Integer idFuturoCliente) {
        FuturoCliente futuroCliente = this.getFuturoCliente(idFuturoCliente);
        this.futuroClienteRepository.delete(futuroCliente);
    }
}
