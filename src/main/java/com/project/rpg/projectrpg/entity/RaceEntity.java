package com.project.rpg.projectrpg.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "race", schema = "warhammer_rpg")
public class RaceEntity extends EntityTemplate{
    private int id;
    private String name;
//    private String translation;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceEntity that = (RaceEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(translation, that.translation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, translation);
    }

    @OneToMany(mappedBy = "raceByRaceId")
    public Collection<CareerRaceEntity> getCareerRacesById() {
        return careerRacesById;
    }

    public void setCareerRacesById(Collection<CareerRaceEntity> careerRacesById) {
        this.careerRacesById = careerRacesById;
    }
}
