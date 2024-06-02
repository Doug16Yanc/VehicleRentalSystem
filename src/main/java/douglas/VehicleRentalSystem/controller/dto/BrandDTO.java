package douglas.VehicleRentalSystem.controller.dto;

import douglas.VehicleRentalSystem.domain.Brand;
import douglas.VehicleRentalSystem.domain.Model;

public record BrandDTO(
        String name,
        String nationality,
        Model model
) {
    public Brand doBrand(){
        return new Brand(
                name,
                nationality,
                new Model(
                        model().getNameModel()
                )
        );
    }
}
