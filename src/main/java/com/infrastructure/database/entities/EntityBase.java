package com.infrastructure.database.entities;

import jakarta.persistence.*;


@MappedSuperclass
public abstract class EntityBase<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
        return this.id;
    }
    public abstract T mapToDomain();

}