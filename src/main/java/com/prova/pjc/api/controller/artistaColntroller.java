package com.prova.pjc.api.controller;



import com.prova.pjc.api.domain.modelo.Artista;
import com.prova.pjc.api.domain.service.ArtistaService;
import com.prova.pjc.infrastructure.spec.ArtistaSpecPorNome;
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
@RequestMapping(value ="/api/v1/artistas")
public class artistaColntroller {

    @Autowired
    private ArtistaService service;

    @GetMapping
    public Page<Artista> listar(@RequestParam(value="page", defaultValue = "0") int page,
                                @RequestParam(value="limit", defaultValue = "12") int limit,
                                @RequestParam(value="direction", defaultValue = "asc") String direction) {

        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "nome"));

        return  service.getRepository().findAll(pageable);
    }


    @GetMapping("/buscar-por-nome")
    public Page<Artista> listar(@RequestParam( value = "nome" , defaultValue ="" ) String nome,
                                @RequestParam(value="page", defaultValue = "0") int page,
                                @RequestParam(value="limit", defaultValue = "12") int limit,
                                @RequestParam(value="direction", defaultValue = "asc") String direction) {

        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;

        var porNomeArtista = new ArtistaSpecPorNome(nome);

        Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "nome"));

        return service.getRepository().findAll(porNomeArtista,pageable);
    }

    @GetMapping("/{id}")
    public Artista buscar(@PathVariable Long id) {
        return service.buscarOuFalhar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Artista adicionar(@RequestBody @Valid Artista artista) {
        return  service.salvar(artista);
    }

    @PutMapping("/{id}")
    public Artista atualizar(@PathVariable Long id,
                             @RequestBody Artista artista) {
        Artista registroAtual = service.buscarOuFalhar(id);
        BeanUtils.copyProperties(artista, registroAtual, "id", "listAlbum");

        return service.salvar(registroAtual);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        service.excluir(id);
    }


}




