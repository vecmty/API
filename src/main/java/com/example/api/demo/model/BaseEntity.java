package com.example.api.demo.model;

import javax.persistence.*;
import java.io.Serializable;

//@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    protected Long id;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

