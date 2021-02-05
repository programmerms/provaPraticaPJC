package com.prova.pjc.api.domain.repository;

import com.prova.pjc.api.domain.modelo.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long>, AlbumRepositoryQuery, JpaSpecificationExecutor {

}
