package com.project.rpg.projectrpg.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "origin_talents", schema = "warhammer_rpg")
public class OriginTalentsEntity {
    private int id;
    private Integer originId;
    private Integer talentsId;
    private OriginEntity originByOriginId;
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
    @Column(name = "origin_id", insertable = false, updatable = false)
    public Integer getOriginId() {
        return originId;
    }

    public void setOriginId(Integer originId) {
        this.originId = originId;
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
        OriginTalentsEntity that = (OriginTalentsEntity) o;
        return id == that.id &&
                Objects.equals(originId, that.originId) &&
                Objects.equals(talentsId, that.talentsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, originId, talentsId);
    }

    @ManyToOne
    @JoinColumn(name = "origin_id", referencedColumnName = "id", table = "origin_talents")
    public OriginEntity getOriginByOriginId() {
        return originByOriginId;
    }

    public void setOriginByOriginId(OriginEntity originByOriginId) {
        this.originByOriginId = originByOriginId;
    }

    @ManyToOne
    @JoinColumn(name = "talents_id", referencedColumnName = "id", table = "origin_talents")
    public TalentsEntity getTalentsByTalentsId() {
        return talentsByTalentsId;
    }

    public void setTalentsByTalentsId(TalentsEntity talentsByTalentsId) {
        this.talentsByTalentsId = talentsByTalentsId;
    }
}
