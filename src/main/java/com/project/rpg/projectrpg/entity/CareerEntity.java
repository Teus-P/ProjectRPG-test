package com.project.rpg.projectrpg.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "career", schema = "warhammer_rpg")
public class CareerEntity {
    private int id;
    private Integer classId;
    private String description;
    private String name;
    private String translation;
    private ClassEntity classByClassId;
    private Collection<CareerPathEntity> careerPathsById;
    private Collection<CareerRaceEntity> careerRacesById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "class_id", insertable = false, updatable = false)
    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        CareerEntity that = (CareerEntity) o;
        return id == that.id &&
                Objects.equals(classId, that.classId) &&
                Objects.equals(description, that.description) &&
                Objects.equals(name, that.name) &&
                Objects.equals(translation, that.translation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, classId, description, name, translation);
    }

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id", table = "career")
    public ClassEntity getClassByClassId() {
        return classByClassId;
    }

    public void setClassByClassId(ClassEntity classByClassId) {
        this.classByClassId = classByClassId;
    }

    @OneToMany(mappedBy = "careerByCareerId")
    public Collection<CareerPathEntity> getCareerPathsById() {
        return careerPathsById;
    }

    public void setCareerPathsById(Collection<CareerPathEntity> careerPathsById) {
        this.careerPathsById = careerPathsById;
    }

    @OneToMany(mappedBy = "careerByCareerId")
    public Collection<CareerRaceEntity> getCareerRacesById() {
        return careerRacesById;
    }

    public void setCareerRacesById(Collection<CareerRaceEntity> careerRacesById) {
        this.careerRacesById = careerRacesById;
    }
}
