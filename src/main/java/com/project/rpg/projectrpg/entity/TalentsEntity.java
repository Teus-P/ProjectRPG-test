package com.project.rpg.projectrpg.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "talents", schema = "warhammer_rpg")
public class TalentsEntity {
    private int id;
    private String name;
    private String translation;
    private String description;
    private Collection<CareerPathTalentsEntity> careerPathTalentsById;
    private Collection<OriginTalentsEntity> originTalentsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "translation")
    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TalentsEntity that = (TalentsEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(translation, that.translation) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, translation, description);
    }

    @OneToMany(mappedBy = "talentsByTalentsId")
    public Collection<CareerPathTalentsEntity> getCareerPathTalentsById() {
        return careerPathTalentsById;
    }

    public void setCareerPathTalentsById(Collection<CareerPathTalentsEntity> careerPathTalentsById) {
        this.careerPathTalentsById = careerPathTalentsById;
    }

    @OneToMany(mappedBy = "talentsByTalentsId")
    public Collection<OriginTalentsEntity> getOriginTalentsById() {
        return originTalentsById;
    }

    public void setOriginTalentsById(Collection<OriginTalentsEntity> originTalentsById) {
        this.originTalentsById = originTalentsById;
    }
}
