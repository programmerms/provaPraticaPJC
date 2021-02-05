package com.prova.pjc.api.domain.service;

import com.prova.pjc.api.domain.exception.AlbumNaoEncontradaException;
import com.prova.pjc.api.domain.exception.ArtistaNaoEncontradaException;
import com.prova.pjc.api.domain.exception.EntidadeEmUsoException;
import com.prova.pjc.api.domain.exception.TipoAlbumNaoEncontradoException;
import com.prova.pjc.api.domain.modelo.Album;
import com.prova.pjc.api.domain.modelo.Artista;
import com.prova.pjc.api.domain.repository.AlbumRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    private static final String MSG_REGISTRO_EM_USO
            = "Registro de Id %d não pode ser removido, pois está em uso";

    @Getter
    @Autowired
    private AlbumRepository repository;

    @Autowired
    private ArtistaService artistaService;



    public Album salvar(Album album) {
        Long idArtista = album.getArtista().getId();
        Artista artista =  artistaService.buscarOuFalhar(idArtista);

        /* Ha um modo mais elegante pra fazer esta validação*/
        album.setTipo(album.getTipo().toUpperCase());
        if (!album.getTipo().equalsIgnoreCase("B") && !album.getTipo().equalsIgnoreCase("C") ){
            throw new TipoAlbumNaoEncontradoException("Tipo do Album inválido, informe B=Banda ou C=CANTOR]");
        }

        album.setArtista(artista);
        return repository.save(album);
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

    public Album buscarOuFalhar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new AlbumNaoEncontradaException(id));
    }



}
