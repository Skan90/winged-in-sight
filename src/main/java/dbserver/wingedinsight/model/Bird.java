package dbserver.wingedinsight.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity(name = "Bird")
@Table(indexes = {
        @Index(name = "name_pt_br_index", columnList = "namePtBr"),
        @Index(name = "name_eng_index", columnList = "nameEng"),
        @Index(name = "species_index", columnList = "species", unique=true),
        @Index(name = "habitat_index", columnList = "habitat")
})
public class Bird implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private Integer id;
    private String namePtBr;
    private String nameEng;
    @Column(unique = true)
    private String species;
    private String family;
    private Integer size;
    private String gender;
    private String color;
    private String habitat;
    private String photo;
    private String localization;

    public Bird() {
    }

    public Bird(Integer id,
                String namePtBr,
                String nameEng,
                String species,
                String family,
                Integer size,
                String gender,
                String color,
                String habitat,
                String photo,
                String localization) {
        this.id = id;
        this.namePtBr = namePtBr;
        this.nameEng = nameEng;
        this.species = species;
        this.family = family;
        this.size = size;
        this.gender = gender;
        this.color = color;
        this.habitat = habitat;
        this.photo = photo;
        this.localization = localization;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamePtBr() {
        return namePtBr;
    }

    public void setNamePtBr(String namePtBr) {

        this.namePtBr = StringUtils.lowerCase(namePtBr);
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = StringUtils.lowerCase(nameEng);
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = StringUtils.lowerCase(species);
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = StringUtils.lowerCase(color);
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = StringUtils.lowerCase(habitat);
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bird bird = (Bird) o;
        return Objects.equals(id, bird.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Bird{" +
                "id=" + id +
                ", namePtBr='" + namePtBr + '\'' +
                ", nameEng='" + nameEng + '\'' +
                ", species='" + species + '\'' +
                ", family='" + family + '\'' +
                ", size=" + size +
                ", gender='" + gender + '\'' +
                ", color='" + color + '\'' +
                ", habitat='" + habitat + '\'' +
                ", photo='" + photo + '\'' +
                ", localization='" + localization + '\'' +
                '}';
    }
}
