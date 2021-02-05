package com.prova.pjc.api.domain.exception;

public class AlbumNaoEncontradaException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public AlbumNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public AlbumNaoEncontradaException(Long id) {
        this(String.format("Registro não encontrador para o Album de ID [%d]", id));
    }


}
