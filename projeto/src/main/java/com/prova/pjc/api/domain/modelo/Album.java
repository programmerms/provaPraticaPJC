package com.prova.pjc.api.domain.modelo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prova.pjc.infrastructure.Groups;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_album")
@AttributeOverride(name = "id", column = @Column(name = "alb_id"))
public class Album extends PersistentEntity {

    @Getter
    @Setter
    @NotBlank(message = "Informe o nome do Artista ou Banda!")
    @Column(name = "alb_nome", length = 100)
    private String nome;

    @Getter
    @Setter
    @ConvertGroup(from = Default.class, to = Groups.ArtistaID.class)
    @NotNull
    @Valid
    @ManyToOne
    @JoinColumn(name = "art_id", nullable = false)
    private Artista artista;

    @Setter
    @Getter
    @NotBlank(message = " Informe um tipo para o album , B =Banda ou C=Cantor ")
    @Column(name = "alb_tipo", nullable = false, length = 1)
    private String tipo;

    @JsonIgnore
    @OneToMany(mappedBy = "album")
    private List<CapaAlbum> capaAlbums = new ArrayList<>();

}
