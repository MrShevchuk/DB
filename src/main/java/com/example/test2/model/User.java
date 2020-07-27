package com.example.test2.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users", schema = "dude_schema")
@Data
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dude_schema.users_id_seq")
    @SequenceGenerator(name = "store.users_id_seq", sequenceName = "dude_schema.users_id_seq", allocationSize = 1)
    private int id;

    @Column(nullable = false)
    private String email;
    @Column
    private String password;
    @Column
    private String adress;
    @Column(name = "created_at")
    private LocalDate creationDate;
}
