package com.prova.pjc.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormataMsgErroException {

    /*
    * Padronizando o formato de problemas no corpo de respostas com a RFC 7807
    * */
    private Integer status;
    private LocalDateTime timestamp;
    private String type;
    private String title;
    private String detail;
    private String userMessage;
    private List<Field> fields;

    /*
    *  Essa classe poderia ser criada fora com um outro nome
    * */
    @Getter
    @Builder
    public static class Field {

        private String name;
        private String userMessage;

    }





}
