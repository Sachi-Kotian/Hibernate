package com.hib;

import jakarta.persistence.*;

@Entity
@Table(name="Prog")
public class Programmer {

    @Id
    int id;

    @Column(name = "Technology")
    String tech;

    @Transient
    int exp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "id=" + id +
                ", tech='" + tech + '\'' +
                ", exp=" + exp +
                '}';
    }
}
