package douglas.VehicleRentalSystem.domain;

import jakarta.persistence.*;

@Embeddable
public class Model {

    @Column(name = "name_model")
    private String nameModel;

    public Model() {

    }

    public Model(String nameModel) {
        this.nameModel = nameModel;
    }


    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }
}
