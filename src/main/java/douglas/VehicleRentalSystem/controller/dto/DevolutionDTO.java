package douglas.VehicleRentalSystem.controller.dto;

import douglas.VehicleRentalSystem.domain.Devolution;
import douglas.VehicleRentalSystem.domain.Rental;
import douglas.VehicleRentalSystem.domain.User;
import douglas.VehicleRentalSystem.domain.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

public record DevolutionDTO(
            UUID id_devolution,
            LocalDateTime rentalDateTime,
            User user,
            Vehicle vehicle

) {
    public Devolution doDevolution() {
        return new Devolution(
                id_devolution,
                rentalDateTime,
                user,
                vehicle
        );
    }
}
