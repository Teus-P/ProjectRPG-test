package com.project.rpg.projectrpg.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "class", schema = "warhammer_rpg")
public class ClassEntity {
    private int id;
    private String name;
    private String translation;
    private Collection<CareerEntity> careersById;

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
        ClassEntity that = (ClassEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(translation, that.translation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, translation);
    }

    @OneToMany(mappedBy = "classByClassId")
    public Collection<CareerEntity> getCareersById() {
        return careersById;
    }

    public void setCareersById(Collection<CareerEntity> careersById) {
        this.careersById = careersById;
    }
}
