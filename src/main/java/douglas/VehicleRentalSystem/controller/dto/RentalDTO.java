package douglas.VehicleRentalSystem.controller.dto;

import douglas.VehicleRentalSystem.domain.Rental;
import douglas.VehicleRentalSystem.domain.User;
import douglas.VehicleRentalSystem.domain.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

public record RentalDTO(
        UUID id_rental,
        LocalDateTime rentalDateTime,
        Double rentalValue,
        User user,
        Vehicle vehicle

) {
    public Rental doRental() {
        return new Rental(
                id_rental,
                rentalDateTime,
                rentalValue,
                user,
                vehicle
        );
    }
}
