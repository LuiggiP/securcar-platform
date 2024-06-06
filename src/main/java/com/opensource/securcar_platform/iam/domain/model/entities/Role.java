package com.opensource.securcar_platform.iam.domain.model.entities;

import com.opensource.securcar_platform.iam.domain.model.valueobjects.Roles;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(length = 20, unique = true, nullable = false)
    private Roles name;

    public Role() {
    }

    public Role(Roles name) {
        this.name = name;
    }
}

