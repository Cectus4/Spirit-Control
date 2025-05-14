package com.cectus4.spirit_control.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "\"emostatistics\"")
public class EmoStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private long userId;
    @Column(nullable = false, length = 1024)
    private String emoDict;
    @Column(nullable = false)
    private LocalDate date;
}
