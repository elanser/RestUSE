package com.example.RestUSE.Entity;

import javax.persistence.*;

// ДЗ Создать двунаправленную
// List<Subject> subjects <- здесь foreign key
// применить "mapped by"

/*
@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients;
 */
@Entity
@Table(name = "\"section\"")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IDSection\"", nullable = false)
    private Long id;

    @Column(name = "\"NameSection\"", nullable = false)
    private String nameSection;

    @Column(name = "\"Parent\"", nullable = false)
    private Long parent;

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

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