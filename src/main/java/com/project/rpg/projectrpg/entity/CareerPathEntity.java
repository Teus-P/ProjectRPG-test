package com.project.rpg.projectrpg.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "career_path", schema = "warhammer_rpg")
public class CareerPathEntity {
    private int id;
    private Integer careerId;
    private String name;
    private String translation;
    private CareerEntity careerByCareerId;
    private Collection<CareerPathTalentsEntity> careerPathTalentsById;
    private Collection<CarrerPathSkillsEntity> carrerPathSkillsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "career_id", insertable = false, updatable = false)
    public Integer getCareerId() {
        return careerId;
    }

    public void setCareerId(Integer careerId) {
        this.careerId = careerId;
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
        CareerPathEntity that = (CareerPathEntity) o;
        return id == that.id &&
                Objects.equals(careerId, that.careerId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(translation, that.translation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, careerId, name, translation);
    }

    @ManyToOne
    @JoinColumn(name = "career_id", referencedColumnName = "id", table = "career_path")
    public CareerEntity getCareerByCareerId() {
        return careerByCareerId;
    }

    public void setCareerByCareerId(CareerEntity careerByCareerId) {
        this.careerByCareerId = careerByCareerId;
    }

    @OneToMany(mappedBy = "careerPathByCareerPathId")
    public Collection<CareerPathTalentsEntity> getCareerPathTalentsById() {
        return careerPathTalentsById;
    }

    public void setCareerPathTalentsById(Collection<CareerPathTalentsEntity> careerPathTalentsById) {
        this.careerPathTalentsById = careerPathTalentsById;
    }

    @OneToMany(mappedBy = "careerPathByCareerPathId")
    public Collection<CarrerPathSkillsEntity> getCarrerPathSkillsById() {
        return carrerPathSkillsById;
    }

    public void setCarrerPathSkillsById(Collection<CarrerPathSkillsEntity> carrerPathSkillsById) {
        this.carrerPathSkillsById = carrerPathSkillsById;
    }
}
