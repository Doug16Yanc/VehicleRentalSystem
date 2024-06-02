package douglas.VehicleRentalSystem.controller.dto;

import douglas.VehicleRentalSystem.domain.Model;

public record ModelDTO(
        String model
) {
    public Model doModel() {
        return new Model(
                model
        );
    }
}
