package com.prova.pjc.api.domain.modelo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_capa_album")
@AttributeOverride(name = "id", column = @Column(name = "cpa_id"))
public class CapaAlbum extends PersistentEntity {


    @Getter
    @Setter
    @NotNull
    @ManyToOne(optional=true,   fetch=FetchType.LAZY)
    @JoinColumn(name = "alb_id", nullable = false)
    private Album album;

    @Getter
    @Setter
    @NotBlank(message = "Informe o nome da capa do Album")
    @Column(name = "art_nome", length = 100)
    private String nome;





    /*
    @Getter
    @Setter
    @NotBlank(message = "Informe o nome do Artista ou Banda!")
    @Column(name = "art_nome", length = 100)
    private String nome;

    @JsonIgnore
    @Getter
    @Setter
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_artista_album", joinColumns = @JoinColumn(name = "art_id"), inverseJoinColumns = @JoinColumn(name = "alb_id"))
    private List<Album> listAlbum;
    */


}
