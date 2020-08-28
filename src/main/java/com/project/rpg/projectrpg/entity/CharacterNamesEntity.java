package com.project.rpg.projectrpg.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "character_names", schema = "warhammer_rpg")
public class CharacterNamesEntity {
    private int id;
    private String name;
    private Integer genderId;
    private Integer originId;
    private GenderEntity genderByGenderId;
    private OriginEntity originByOriginId;

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
    @Column(name = "gender_id", insertable = false, updatable = false)
    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    @Basic
    @Column(name = "origin_id", insertable = false, updatable = false)
    public Integer getOriginId() {
        return originId;
    }

    public void setOriginId(Integer originId) {
        this.originId = originId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterNamesEntity that = (CharacterNamesEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(genderId, that.genderId) &&
                Objects.equals(originId, that.originId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, genderId, originId);
    }

    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id", table = "character_names")
    public GenderEntity getGenderByGenderId() {
        return genderByGenderId;
    }

    public void setGenderByGenderId(GenderEntity genderByGenderId) {
        this.genderByGenderId = genderByGenderId;
    }

    @ManyToOne
    @JoinColumn(name = "origin_id", referencedColumnName = "id", table = "character_names")
    public OriginEntity getOriginByOriginId() {
        return originByOriginId;
    }

    public void setOriginByOriginId(OriginEntity originByOriginId) {
        this.originByOriginId = originByOriginId;
    }
}
