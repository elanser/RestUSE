package com.example.RestUSE.Entity;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role", nullable = false)
    private Long id;

    @Column(name = "namerole", nullable = false)
    private String namerole;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamerole() {
        return namerole;
    }

    public void setNamerole(String namerole) {
        this.namerole = namerole;
    }

}