package com.prova.pjc.infrastructure.spec;


import com.prova.pjc.api.domain.modelo.Album;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@AllArgsConstructor
public class AlbumSpecPorNomeArtista implements Specification<Album> {

    private static final long serialVersionUID = 1L;

    private String nomeArtista;



    @Override
    public Predicate toPredicate(Root<Album> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder) {

        if( nomeArtista!=null && !nomeArtista.isEmpty()){


           return  builder.like(root.get("artista").get("nome"), "%" + nomeArtista + "%");
        }
        return null;

    }
}
