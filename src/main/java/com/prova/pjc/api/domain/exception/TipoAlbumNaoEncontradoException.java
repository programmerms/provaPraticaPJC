package com.prova.pjc.api.domain.exception;

public class TipoAlbumNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public TipoAlbumNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public TipoAlbumNaoEncontradoException(Long id) {
        this(String.format("Tipo do Album inválido, informe B=Banda OU C=Cantor"));
    }


}
