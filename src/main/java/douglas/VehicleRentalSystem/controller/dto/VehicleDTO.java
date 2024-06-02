package douglas.VehicleRentalSystem.controller.dto;

import douglas.VehicleRentalSystem.domain.Brand;
import douglas.VehicleRentalSystem.domain.Vehicle;

public record VehicleDTO(
        int numberPlate,
        String color,
        int year,
        String typeFuel,
        int doorsNumber,
        Double mileage,
        Long renavam,
        String chassi,
        Double rentalValue,
        Brand brand
) {
    public Vehicle doVehicle() {
        return new Vehicle(
                numberPlate,
                color,
                year,
                typeFuel,
                doorsNumber,
                mileage,
                renavam,
                chassi,
                rentalValue,
                new Brand(
                        brand.getNameBrand(),
                        brand.getNationality(),
                        brand.getModels()
                )
        );
    }
}
