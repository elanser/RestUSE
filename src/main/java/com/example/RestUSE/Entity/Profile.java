package com.example.RestUSE.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name = "profile")
@Proxy(lazy = false)
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile", nullable = false)
    private Long id;

    public Long getId_section() {
        return id_section;
    }

    @Column(name = "id_section", nullable=false)
    private Long id_section;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_section", nullable = false, insertable=false, updatable=false)
    private Section idSection;

    @Column(name = "name_profile", nullable = false, length = 1024)
    private String nameProfile;

    @Column(name = "num_tickets", nullable = false)
    private Integer numTickets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Section getIdSection() {
        return idSection;
    }

    public void setIdSection(Section idSection) {
        this.idSection = idSection;
    }

    public String getNameProfile() {
        return nameProfile;
    }

    public void setNameProfile(String nameProfile) {
        this.nameProfile = nameProfile;
    }

    public Integer getNumTickets() {
        return numTickets;
    }

    public void setNumTickets(Integer numTickets) {
        this.numTickets = numTickets;
    }

}