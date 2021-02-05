package com.prova.pjc.infrastructure;


import com.prova.pjc.api.domain.repository.AlbumRepositoryQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AlbumRepositoryImpl implements AlbumRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    // Preparado para implementaçao de consultas JPQL ou Criteria se for o caso

}
