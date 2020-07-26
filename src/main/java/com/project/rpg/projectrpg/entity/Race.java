package com.project.rpg.projectrpg.entity;

import javax.persistence.*;

@Entity
@Table(name = "race")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "translation")
    private String translation;

    public Race() {
    }

    public Race(String name, String translation) {
        this.name = name;
        this.translation = translation;
    }

    public Race(int id, String name, String translation) {
        this.id = id;
        this.name = name;
        this.translation = translation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String raceName) {
        this.name = raceName;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String raceTranslation) {
        this.translation = raceTranslation;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", raceName='" + name + '\'' +
                ", raceTranslation='" + translation + '\'' +
                '}';
    }
}
