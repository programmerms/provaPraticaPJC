package com.prova.pjc.api.domain.repository;

import com.prova.pjc.api.domain.modelo.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> , JpaSpecificationExecutor {



}
