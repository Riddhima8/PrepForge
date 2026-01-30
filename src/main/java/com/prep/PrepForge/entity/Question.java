package com.prep.PrepForge.entity;

import jakarta.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String difficulty;
    private String topic;

    @Column(length = 5000)
    private String description;

    // getters & setters
}
