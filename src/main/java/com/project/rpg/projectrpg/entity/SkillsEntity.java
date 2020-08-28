package com.project.rpg.projectrpg.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "skills", schema = "warhammer_rpg")
public class SkillsEntity {
    private int id;
    private String name;
    private String translation;
    private Collection<CarrerPathSkillsEntity> carrerPathSkillsById;
    private Collection<OriginSkillsEntity> originSkillsById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillsEntity that = (SkillsEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(translation, that.translation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, translation);
    }

    @OneToMany(mappedBy = "skillsBySkillsId")
    public Collection<CarrerPathSkillsEntity> getCarrerPathSkillsById() {
        return carrerPathSkillsById;
    }

    public void setCarrerPathSkillsById(Collection<CarrerPathSkillsEntity> carrerPathSkillsById) {
        this.carrerPathSkillsById = carrerPathSkillsById;
    }

    @OneToMany(mappedBy = "skillsBySkillsId")
    public Collection<OriginSkillsEntity> getOriginSkillsById() {
        return originSkillsById;
    }

    public void setOriginSkillsById(Collection<OriginSkillsEntity> originSkillsById) {
        this.originSkillsById = originSkillsById;
    }
}
