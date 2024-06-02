package douglas.VehicleRentalSystem.domain;

import jakarta.persistence.*;

@Embeddable
public class Brand {

    @Column(name = "name_brand")
    private String nameBrand;

    @Column(name = "nationality_brand")
    private String nationality;

    @Embedded
    private Model models;

    public Brand() {

    }
    public Brand(String nameBrand, String nationality, Model models) {
        this.nameBrand = nameBrand;
        this.nationality = nationality;
        this.models = models;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Model getModels() {
        return models;
    }

    public void setModels(Model models) {
        this.models = models;
    }
}
