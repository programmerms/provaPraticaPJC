package com.prova.pjc.api.core.security;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@EqualsAndHashCode
public class CredencialContaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

}
