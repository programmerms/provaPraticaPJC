package com.prova.pjc.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public interface IPersistentEntity<T extends Serializable> {
    /**
     * @return the ID of the entity
     */
    T getId();

    /**
     * @return if the entity is saved or not
     */
    @JsonIgnore
    boolean isNew();

    /**
     * If this entity is saved or not checking by the presence of the ID value
     *
     * @return true if is saved, false otherwise
     */
    boolean isSaved();

    /**
     * Sames as {@link #isSaved()} but in this case inverted for convenience use in lambda expressions
     *
     * @return true if not saved, false otherwise
     */
    @JsonIgnore
    default boolean isNotSaved() {

        return !this.isSaved();
    }


}
