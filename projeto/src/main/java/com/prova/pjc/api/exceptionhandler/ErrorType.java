package com.prova.pjc.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ErrorType {

    DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos"),
    ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema"),
    PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro inválido"),
    MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível"),
    ENTIDADE_NAO_ENCONTRADA("/entidade-nao-encontrada", "Entidade não encontrada"),
    ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
    ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio"),
    ERRO_AUTENTICACAO("/erro-autenticacao", "Erro de Autenticação");


    private String title;
    private String uri;

    ErrorType(String path, String title) {
        this.uri = "https://www.pjc.mt.gov.br" + path;
        this.title = title;
    }
}
