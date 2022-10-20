package dbserver.wingedinsight.model.dto;

public class BirdDto {
    private Integer id;
    private String commonName;
    private String birdOrder;
    private String family;
    private String genus;
    private String species;
    private String photo;
    private String localization;

    public BirdDto(Integer id,
                   String commonName,
                   String birdOrder,
                   String family,
                   String genus,
                   String species,
                   String photo,
                   String localization) {
        this.id = id;
        this.commonName = commonName;
        this.birdOrder = birdOrder;
        this.family = family;
        this.genus = genus;
        this.species = species;
        this.photo = photo;
        this.localization = localization;
    }

    public BirdDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getBirdOrder() {
        return birdOrder;
    }

    public void setBirdOrder(String birdOrder) {
        this.birdOrder = birdOrder;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
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
}
