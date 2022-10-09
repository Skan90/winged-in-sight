package dbserver.wingedinsight.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.persistence.Table;

@Entity
@Table(name = "birds")
public class Bird extends BaseEntity {

  @Column(name = "popular_name")
  @NotEmpty
  protected String popularName;

  @Column(name = "scientific_name")
  @NotEmpty
  protected String scientificName;
  @Column(name = "color")
  @NotEmpty
  protected String color;
  @Column(name = "localization")
  @NotEmpty
  protected String localization;
  @Column(name = "photo")
  @NotEmpty
  protected String photo;

  public Bird(String popularName, String scientificName, String color, String localization, String photo) {
    this.popularName = popularName;
    this.scientificName = scientificName;
    this.color = color;
    this.localization = localization;
    this.photo = photo;
  }

  public Bird() {

  }

  public String getPopularName() {
    return this.popularName;
  }

  public void setPopularName(String popularName) {
    this.popularName = popularName;
  }

  public String getScientificName() {
    return this.scientificName;
  }

  public void setScientificName(String scientificName) {
    this.scientificName = scientificName;
  }

  public String getColor() {
    return this.color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getLocalization() {
    return this.localization;
  }

  public void setLocalization(String localization) {
    this.localization = localization;
  }

  public String getPhoto() {
    return this.photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  @Override
  public String toString() {
    return "{" +
        " id='" + getId() + "'" +
        ", popularName='" + getPopularName() + "'" +
        ", scientificName='" + getScientificName() + "'" +
        ", color='" + getColor() + "'" +
        ", localization='" + getLocalization() + "'" +
        ", photo='" + getPhoto() + "'" +
        "}";
  }

}
