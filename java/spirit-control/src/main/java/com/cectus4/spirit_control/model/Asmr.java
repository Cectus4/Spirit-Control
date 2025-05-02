package com.cectus4.spirit_control.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "\"asmr\"")
public class Asmr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String url;
}
