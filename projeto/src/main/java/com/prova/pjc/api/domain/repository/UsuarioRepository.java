package com.prova.pjc.api.domain.repository;


import com.prova.pjc.api.domain.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select u from Usuario u WHERE u.userName =:userName")
    Usuario findByUsername(@Param("userName") String userName);

}
