package com.project.rpg.projectrpg.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "career_race", schema = "warhammer_rpg")
public class CareerRaceEntity {
    private int id;
    private Integer careerId;
    private Integer raceId;
    private CareerEntity careerByCareerId;
    private RaceEntity raceByRaceId;

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
    @Column(name = "race_id", insertable = false, updatable = false)
    public Integer getRaceId() {
        return raceId;
    }

    public void setRaceId(Integer raceId) {
        this.raceId = raceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CareerRaceEntity that = (CareerRaceEntity) o;
        return id == that.id &&
                Objects.equals(careerId, that.careerId) &&
                Objects.equals(raceId, that.raceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, careerId, raceId);
    }

    @ManyToOne
    @JoinColumn(name = "career_id", referencedColumnName = "id", table = "career_race")
    public CareerEntity getCareerByCareerId() {
        return careerByCareerId;
    }

    public void setCareerByCareerId(CareerEntity careerByCareerId) {
        this.careerByCareerId = careerByCareerId;
    }

    @ManyToOne
    @JoinColumn(name = "race_id", referencedColumnName = "id", table = "career_race")
    public RaceEntity getRaceByRaceId() {
        return raceByRaceId;
    }

    public void setRaceByRaceId(RaceEntity raceByRaceId) {
        this.raceByRaceId = raceByRaceId;
    }
}
