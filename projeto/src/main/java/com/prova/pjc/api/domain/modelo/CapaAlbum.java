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
    @NotBlank(message = "A descrição da capa do album deve ser informada!")
    @Column(name = "cpa_descricao", length = 100)
    private String descricao;

    @Getter
    @Setter
    @NotBlank(message = "O content type dever informado!")
    @Column(name = "cpa_content_type", length = 100)
    private String contentType;

    @Getter
    @Setter
    @NotBlank(message = "O nome do arquivo de imagem dever ser informado!")
    @Column(name = "cpa_nomer_arquivo", length = 150)
    private String nome;

    @Getter
    @Setter
    @NotNull
    @Column(name = "cpa_tamanho")
    private Long tamanho;

}
