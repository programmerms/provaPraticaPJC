package com.prova.pjc.api.domain.exception;

public class ArtistaNaoEncontradaException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public ArtistaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public ArtistaNaoEncontradaException(Long id) {
        this(String.format("Registro não encontrado para o Artista de ID [%d]", id));
    }


}
