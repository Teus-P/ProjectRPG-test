package com.project.rpg.projectrpg.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "carrer_path_skills", schema = "warhammer_rpg")
public class CarrerPathSkillsEntity {
    private int id;
    private Integer careerPathId;
    private Integer skillsId;
    private CareerPathEntity careerPathByCareerPathId;
    private SkillsEntity skillsBySkillsId;

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
    @Column(name = "skills_id", insertable = false, updatable = false)
    public Integer getSkillsId() {
        return skillsId;
    }

    public void setSkillsId(Integer skillsId) {
        this.skillsId = skillsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarrerPathSkillsEntity that = (CarrerPathSkillsEntity) o;
        return id == that.id &&
                Objects.equals(careerPathId, that.careerPathId) &&
                Objects.equals(skillsId, that.skillsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, careerPathId, skillsId);
    }

    @ManyToOne
    @JoinColumn(name = "career_path_id", referencedColumnName = "id", table = "carrer_path_skills")
    public CareerPathEntity getCareerPathByCareerPathId() {
        return careerPathByCareerPathId;
    }

    public void setCareerPathByCareerPathId(CareerPathEntity careerPathByCareerPathId) {
        this.careerPathByCareerPathId = careerPathByCareerPathId;
    }

    @ManyToOne
    @JoinColumn(name = "skills_id", referencedColumnName = "id", table = "carrer_path_skills")
    public SkillsEntity getSkillsBySkillsId() {
        return skillsBySkillsId;
    }

    public void setSkillsBySkillsId(SkillsEntity skillsBySkillsId) {
        this.skillsBySkillsId = skillsBySkillsId;
    }
}
