package com.example.task2.domain;

import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
public abstract class EntityWithRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long relatedEntityId;
}
