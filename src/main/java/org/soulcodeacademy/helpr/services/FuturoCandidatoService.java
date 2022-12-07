package org.soulcodeacademy.helpr.services;
import org.soulcodeacademy.helpr.domain.FuturoCandidato;
import org.soulcodeacademy.helpr.domain.dto.FuturoCandidatoDTO;
import org.soulcodeacademy.helpr.domain.enums.Setor;
import org.soulcodeacademy.helpr.repositories.FuturoCandidatoRepository;
import org.soulcodeacademy.helpr.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuturoCandidatoService {

    @Autowired
    private FuturoCandidatoRepository futuroCandidatoRepository;

    public List<FuturoCandidato> listaTodos() {
        return this.futuroCandidatoRepository.findAll();
    }

    public FuturoCandidato getFuturoCandidato(Integer idCandidatoFuturo) {
        Optional<FuturoCandidato> futuroCandidato = this.futuroCandidatoRepository.findById(idCandidatoFuturo);

        if (futuroCandidato.isEmpty()) {
            // lançar exceção
            throw new RecursoNaoEncontradoError("Futuro candidato não encontrado!");
        } else {
            return futuroCandidato.get();
        }
    }

    public List<FuturoCandidato> listarPorNome (String nomeCompleto) {

        return this.futuroCandidatoRepository.findByNomeCompletoContaining(nomeCompleto);
    }

    public List<FuturoCandidato> listarPorSetor (Setor setor) {

        return this.futuroCandidatoRepository.findBySetor(setor);
    }

    public List<FuturoCandidato> listarPorEmail (String emailCandidato) {
        return this.futuroCandidatoRepository.findByEmailCandidato(emailCandidato);
    }

    public FuturoCandidato salvar (FuturoCandidatoDTO dto) {
        FuturoCandidato novoCadidato = new FuturoCandidato(null, dto.getNomeCompleto(), dto.getEmailCandidato(), dto.getDescricao(), dto.getSetor());

        return this.futuroCandidatoRepository.save(novoCadidato);
    }

    public void deletarCandidato(Integer idFuturoCandidato) {
        FuturoCandidato futuroCandidato = this.getFuturoCandidato(idFuturoCandidato);
        this.futuroCandidatoRepository.delete(futuroCandidato);
    }
}




