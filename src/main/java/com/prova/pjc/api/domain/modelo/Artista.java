package com.prova.pjc.api.domain.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.prova.pjc.infrastructure.Groups;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_artista")
@AttributeOverride(name = "id", column = @Column(name = "art_id"))
public class Artista extends PersistentEntity {

    @Override
    @NotNull(groups = {Groups.ArtistaID.class},
            message = "O ID do Artista deve ser informado.")
    public Long getId() {
        return super.getId();
    }

    @Getter
    @Setter
    @NotBlank(message = "Informe o nome do Artista ou Banda!")
    @Column(name = "art_nome", length = 100)
    private String nome;

    @Setter
    @Getter
    @JsonIgnore
    @OneToMany(mappedBy = "artista", fetch = FetchType.LAZY)
    private List<Album> listaAlbum = new ArrayList<>();


}
