package com.project.rpg.projectrpg.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "origin_skills", schema = "warhammer_rpg")
public class OriginSkillsEntity {
    private int id;
    private Integer originId;
    private Integer skillsId;
    private OriginEntity originByOriginId;
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
    @Column(name = "origin_id", insertable = false, updatable = false)
    public Integer getOriginId() {
        return originId;
    }

    public void setOriginId(Integer originId) {
        this.originId = originId;
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
        OriginSkillsEntity that = (OriginSkillsEntity) o;
        return id == that.id &&
                Objects.equals(originId, that.originId) &&
                Objects.equals(skillsId, that.skillsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, originId, skillsId);
    }

    @ManyToOne
    @JoinColumn(name = "origin_id", referencedColumnName = "id", table = "origin_skills")
    public OriginEntity getOriginByOriginId() {
        return originByOriginId;
    }

    public void setOriginByOriginId(OriginEntity originByOriginId) {
        this.originByOriginId = originByOriginId;
    }

    @ManyToOne
    @JoinColumn(name = "skills_id", referencedColumnName = "id", table = "origin_skills")
    public SkillsEntity getSkillsBySkillsId() {
        return skillsBySkillsId;
    }

    public void setSkillsBySkillsId(SkillsEntity skillsBySkillsId) {
        this.skillsBySkillsId = skillsBySkillsId;
    }
}
