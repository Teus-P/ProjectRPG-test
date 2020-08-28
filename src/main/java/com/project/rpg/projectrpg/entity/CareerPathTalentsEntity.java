package com.project.rpg.projectrpg.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "career_path_talents", schema = "warhammer_rpg")
public class CareerPathTalentsEntity {
    private int id;
    private Integer careerPathId;
    private Integer talentsId;
    private CareerPathEntity careerPathByCareerPathId;
    private TalentsEntity talentsByTalentsId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "career_path_id", insertable = false, updatable = false)
    public Integer getCareerPathId() {
        return careerPathId;
    }

    public void setCareerPathId(Integer careerPathId) {
        this.careerPathId = careerPathId;
    }

    @Basic
    @Column(name = "talents_id", insertable = false, updatable = false)
    public Integer getTalentsId() {
        return talentsId;
    }

    public void setTalentsId(Integer talentsId) {
        this.talentsId = talentsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CareerPathTalentsEntity that = (CareerPathTalentsEntity) o;
        return id == that.id &&
                Objects.equals(careerPathId, that.careerPathId) &&
                Objects.equals(talentsId, that.talentsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, careerPathId, talentsId);
    }

    @ManyToOne
    @JoinColumn(name = "career_path_id", referencedColumnName = "id", table = "career_path_talents")
    public CareerPathEntity getCareerPathByCareerPathId() {
        return careerPathByCareerPathId;
    }

    public void setCareerPathByCareerPathId(CareerPathEntity careerPathByCareerPathId) {
        this.careerPathByCareerPathId = careerPathByCareerPathId;
    }

    @ManyToOne
    @JoinColumn(name = "talents_id", referencedColumnName = "id", table = "career_path_talents")
    public TalentsEntity getTalentsByTalentsId() {
        return talentsByTalentsId;
    }

    public void setTalentsByTalentsId(TalentsEntity talentsByTalentsId) {
        this.talentsByTalentsId = talentsByTalentsId;
    }
}
