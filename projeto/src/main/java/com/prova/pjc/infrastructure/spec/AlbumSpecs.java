package com.prova.pjc.infrastructure.spec;


import com.prova.pjc.api.domain.modelo.Album;
import org.springframework.data.jpa.domain.Specification;

public class AlbumSpecs {

    public static Specification<Album> porNomeArtista(String nomeArtista) {

        return new AlbumSpecPorNomeArtista(nomeArtista);
    }



}
