package com.prova.pjc.api.domain.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.prova.pjc.api.domain.IPersistentEntity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@ToString(of = {"id"})
@MappedSuperclass
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public abstract class PersistentEntity implements IPersistentEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Getter
    @Setter

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Setter
    @Getter
    @JsonIgnore
    @CreationTimestamp
    @Column(name = "data_criacao", columnDefinition = "datetime")
    private LocalDateTime dataCriacao;

    @Setter
    @Getter
    @JsonIgnore
    @UpdateTimestamp
    @Column(name = "data_alteracao", columnDefinition = "datetime")
    private LocalDateTime dataAlteracao;

/*
    @PrePersist
    protected void beforeInsert() {
        this.dataCriacao = LocalDateTime.now();
        this.dataAlteracao = LocalDateTime.now();
    }

    @PreUpdate
    protected void beforeUpdate() {
        this.dataAlteracao = LocalDateTime.now();
    }
*/

    @Override
    @JsonIgnore
    public boolean isNew() {
        return (this.id == null);
    }


    @Override
    @JsonIgnore
    public boolean isSaved() {
        return this.id != null && this.id != 0;
    }



}