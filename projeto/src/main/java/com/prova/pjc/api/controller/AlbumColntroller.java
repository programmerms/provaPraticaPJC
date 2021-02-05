package com.prova.pjc.api.controller;

import com.prova.pjc.api.domain.exception.ArtistaNaoEncontradaException;
import com.prova.pjc.api.domain.exception.NegocioException;
import com.prova.pjc.api.domain.exception.TipoAlbumNaoEncontradoException;
import com.prova.pjc.api.domain.modelo.Album;
import com.prova.pjc.api.domain.service.AlbumService;
import com.prova.pjc.infrastructure.spec.AlbumSpecPorNomeArtista;
import com.prova.pjc.infrastructure.spec.AlbumSpecTipoAlbum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value ="/api/v1/albuns")
public class AlbumColntroller {

    @Autowired
    private AlbumService service;

    @GetMapping
    public Page<Album> listar(@RequestParam(value="page", defaultValue = "0") int page,
                              @RequestParam(value="limit", defaultValue = "12") int limit,
                              @RequestParam(value="direction", defaultValue = "asc") String direction) {

        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "nome"));


        return service.getRepository().findAll(pageable);
    }

    @GetMapping("/buscar-por-parametros")
    public Page<Album> buscarAlbuns(@RequestParam( value = "nomeArtista" , defaultValue ="" ) String nomeArtista,
                                    @RequestParam( value = "tipoAlbum" , defaultValue ="" ) String tipoAlbum,
                                    @RequestParam(value="page", defaultValue = "0") int page,
                                    @RequestParam(value="limit", defaultValue = "12") int limit,
                                    @RequestParam(value="direction", defaultValue = "asc") String direction) {

        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;


        if(!tipoAlbum.isEmpty()){
            tipoAlbum = (tipoAlbum.toUpperCase().equals("B") ||
                         tipoAlbum.toUpperCase().equals("C")?tipoAlbum.toUpperCase():"");
        }

        var porNomeArtista = new AlbumSpecPorNomeArtista(nomeArtista);
        var porTipoAlbum   = new AlbumSpecTipoAlbum(tipoAlbum);

        Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "artista.nome"));


        return service.getRepository().findAll(porNomeArtista.and(porTipoAlbum),pageable);
    }


    @GetMapping("/{id}")
    public Album buscar(@PathVariable Long id) {
        return service.buscarOuFalhar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Album adicionar(@RequestBody @Valid Album album) {

        try {
            return service.salvar(album);
        } catch (TipoAlbumNaoEncontradoException e) {
            throw new NegocioException(e.getMessage(), e);
        } catch (ArtistaNaoEncontradaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @PutMapping("/{id}")
    public Album atualizar(@PathVariable Long id,
                             @RequestBody Album album) {
        try {
            Album registroAtual = service.buscarOuFalhar(id);

            BeanUtils.copyProperties(album, registroAtual, "id", "dataCriacao", "capaAlbums");

            return service.salvar(registroAtual);
        } catch (ArtistaNaoEncontradaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        service.excluir(id);
    }


}




