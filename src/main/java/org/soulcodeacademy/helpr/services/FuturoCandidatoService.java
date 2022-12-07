package org.soulcodeacademy.helpr.services;

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.Cliente;
import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.dto.ClienteDTO;
import org.soulcodeacademy.helpr.domain.dto.FuturoCandidatoDTO;
import org.soulcodeacademy.helpr.domain.enums.Setor;
import org.soulcodeacademy.helpr.repositories.ChamadoRepository;
import org.soulcodeacademy.helpr.repositories.FuturoCandidatoRepository;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class FuturoCandidatoService {

    @Autowired
    private FuturoCandidatoRepository futuroCandidatoRepository;

    public List<FuturoCandidato> listar() {
        return this.futuroCandidatoRepository.findAll();
    }

    public FuturoCandidato getFuturoCandidato(Integer idFuturoCandidato) {
        Optional<FuturoCandidato> futuroCandidato = this.futuroCandidatoRepository.findById(idFuturoCandidato);

        if (futuroCandidato.isEmpty()) {
            throw new RecursoNaoEncontradoError("O Futuro candidato não foi encontrado!");
        } else {
            return futuroCandidato.get();
        }
    }
   public List<FuturoCandidato> listarPorEmail(String email){
        return this.futuroCandidatoRepository.findByEmail(email);
   }
    public List<FuturoCandidato> listarPorNome(String nome){
        return this.futuroCandidatoRepository.findByNomeContaining(nome);
    }
    public List<FuturoCandidato> listarPorSetor(Setor setor){
        return this.futuroCandidatoRepository.findBySetorContaining(setor);
    }
    public FuturoCandidato salvar(FuturoCandidatoDTO dto) {
        FuturoCandidato novoFuturoCandidato = new FuturoCandidato(null, dto.getNomeCompleto(), dto.getEmail(), dto.getDescricaoDasHabilidades(), dto.getSetor());
        return this.futuroCandidatoRepository.save(novoFuturoCandidato);
    }
    public void deletar(Integer idFuturoCandidato) {
        FuturoCandidato futuroCandidato = this.getFuturoCandidato(idFuturoCandidato);
        // DELETE FROM cargo WHERE idCargo = ?
        this.futuroCandidatoRepository.delete(futuroCandidato);
    }
}


