package com.cectus4.spirit_control.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "\"users\"")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;
    private Boolean gender;
    @Column(unique = true)
    private String email;

}
