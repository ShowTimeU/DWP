package com.dontwaste.model.customer.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public abstract class BaseId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ID", nullable = false, unique = true)
    private Long id;
}
