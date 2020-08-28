package com.project.rpg.projectrpg.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "gender", schema = "warhammer_rpg")
public class GenderEntity {
    private int id;
    private String name;
    private String translation;
    private Collection<CharacterNamesEntity> characterNamesById;

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
        GenderEntity that = (GenderEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(translation, that.translation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, translation);
    }

    @OneToMany(mappedBy = "genderByGenderId")
    public Collection<CharacterNamesEntity> getCharacterNamesById() {
        return characterNamesById;
    }

    public void setCharacterNamesById(Collection<CharacterNamesEntity> characterNamesById) {
        this.characterNamesById = characterNamesById;
    }
}
