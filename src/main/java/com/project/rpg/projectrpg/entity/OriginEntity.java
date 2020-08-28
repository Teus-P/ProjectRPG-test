package com.project.rpg.projectrpg.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "origin", schema = "warhammer_rpg")
public class OriginEntity {
    private int id;
    private Integer name;
    private Integer raceId;
    private String translation;
    private Collection<CharacterNamesEntity> characterNamesById;
    private Collection<OriginSkillsEntity> originSkillsById;
    private Collection<OriginTalentsEntity> originTalentsById;

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
    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    @Basic
    @Column(name = "race_id", insertable = false, updatable = false)
    public Integer getRaceId() {
        return raceId;
    }

    public void setRaceId(Integer raceId) {
        this.raceId = raceId;
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
        OriginEntity that = (OriginEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(raceId, that.raceId) &&
                Objects.equals(translation, that.translation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, raceId, translation);
    }

    @OneToMany(mappedBy = "originByOriginId")
    public Collection<CharacterNamesEntity> getCharacterNamesById() {
        return characterNamesById;
    }

    public void setCharacterNamesById(Collection<CharacterNamesEntity> characterNamesById) {
        this.characterNamesById = characterNamesById;
    }

    @OneToMany(mappedBy = "originByOriginId")
    public Collection<OriginSkillsEntity> getOriginSkillsById() {
        return originSkillsById;
    }

    public void setOriginSkillsById(Collection<OriginSkillsEntity> originSkillsById) {
        this.originSkillsById = originSkillsById;
    }

    @OneToMany(mappedBy = "originByOriginId")
    public Collection<OriginTalentsEntity> getOriginTalentsById() {
        return originTalentsById;
    }

    public void setOriginTalentsById(Collection<OriginTalentsEntity> originTalentsById) {
        this.originTalentsById = originTalentsById;
    }
}
