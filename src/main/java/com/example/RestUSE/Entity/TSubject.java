package com.example.RestUSE.Entity;

import javax.persistence.*;

@Entity
@Table(name = "\"tSubject\"")
public class TSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IDSubject\"", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"IDSection\"", nullable = false)
    private TSection iDSection;

    @Column(name = "\"NameSubject\"", nullable = false)
    private String nameSubject;

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public TSection getIDSection() {
        return iDSection;
    }

    public void setIDSection(TSection iDSection) {
        this.iDSection = iDSection;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}