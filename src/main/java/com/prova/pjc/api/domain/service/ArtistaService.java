package com.prova.pjc.api.domain.service;


import com.prova.pjc.api.domain.exception.ArtistaNaoEncontradaException;
import com.prova.pjc.api.domain.exception.EntidadeEmUsoException;
import com.prova.pjc.api.domain.modelo.Artista;
import com.prova.pjc.api.domain.repository.ArtistaRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ArtistaService {

    private static final String MSG_REGISTRO_EM_USO
            = "Registro de id %d não pode ser removido, pois está em uso";

    @Autowired
    @Getter
    private ArtistaRepository repository;

    public Artista salvar(Artista artista) {
        return repository.save(artista);
    }

    public void excluir(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ArtistaNaoEncontradaException(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_REGISTRO_EM_USO, id));
        }
    }

    public Artista buscarOuFalhar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ArtistaNaoEncontradaException(id));
    }


}
