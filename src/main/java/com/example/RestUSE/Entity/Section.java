package com.example.RestUSE.Entity;

import javax.persistence.*;

@Entity
@Table(name = "\"section\"")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IDSection\"", nullable = false)
    private Long id;

    @Column(name = "\"NameSection\"", nullable = false)
    private String nameSection;

    public String getNameSection() {
        return nameSection;
    }

    public void setNameSection(String nameSection) {
        this.nameSection = nameSection;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}