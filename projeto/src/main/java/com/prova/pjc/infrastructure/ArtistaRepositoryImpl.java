package com.prova.pjc.infrastructure;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ArtistaRepositoryImpl {

    @PersistenceContext
    private EntityManager manager;

    // Preparado para implementaçao de consultas JPQL ou Criteria se for o caso

}
