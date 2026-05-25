package com.study.Study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "customer", schema = "public", indexes = {
        @Index(name = "idx_fk_store_id",
                columnList = "store_id"),
        @Index(name = "idx_last_name",
                columnList = "last_name"),
        @Index(name = "idx_fk_address_id",
                columnList = "address_id")})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_gen")
    @SequenceGenerator(name = "customer_id_gen", sequenceName = "customer_customer_id_seq", allocationSize = 1)
    @Column(name = "customer_id", nullable = false)
    private Integer id;

    @Column(name = "store_id", nullable = false)
    private Short storeId;

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(name = "email", length = 50)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @ColumnDefault("true")
    @Column(name = "activebool", nullable = false)
    private Boolean activebool;

    @ColumnDefault("('now')")
    @Column(name = "create_date", nullable = false)
    private LocalDate createDate;

    @ColumnDefault("now()")
    @Column(name = "last_update")
    private Instant lastUpdate;

    @Column(name = "active")
    private Integer active;


}