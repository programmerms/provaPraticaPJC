package com.prova.pjc.api.domain.modelo;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_permissao")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class Permissao  extends PersistentEntity  implements GrantedAuthority {


    @Setter
    @Getter
    @Column(name = "description")
    private String description;

    @Override
    public String getAuthority() {
        return this.description;
    }


}
