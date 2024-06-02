package douglas.VehicleRentalSystem.controller;

import douglas.VehicleRentalSystem.controller.dto.VehicleDTO;
import douglas.VehicleRentalSystem.domain.Vehicle;
import douglas.VehicleRentalSystem.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class VehicleController {

    private final VehicleService vehicleService;


    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/vehicles")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<String> saveVehicle(@RequestBody VehicleDTO vehicleDTO){

        var vehicle = vehicleService.saveVehicle(vehicleDTO);

        return ResponseEntity.status(HttpStatus.OK).body("Vehicle " + vehicle.getId() + " " + vehicle.getBrand().getNameBrand() +  " saved successfully.");


    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle> findVehicleById(@PathVariable("id") Long id) {
        Optional<Vehicle> vehicleFound = vehicleService.findById(id);

        if (vehicleFound.isPresent()) {
            Vehicle vehicle = vehicleFound.get();
            return ResponseEntity.ok(vehicle);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list_vehicles")
    public ResponseEntity<List<Vehicle>> listVehicles() {

        var vehicles = vehicleService.findAll();

        return ResponseEntity.ok(vehicles);

        /*
        List<Vehicle> vehicles = vehicleService.listVehicles();
        List<VehicleDTO> vehicleDTOList = new ArrayList<>();

        if (!vehicles.isEmpty()) {
            for (Vehicle vehicle : vehicles) {
                vehicleDTOList.add(new VehicleDTO(vehicle.getPlateNumber(),
                        vehicle.getColor(), vehicle.getYear(), vehicle.getFuelType(),
                        vehicle.getDoorsNumber(), vehicle.getMileage(), vehicle.getRenavam(),
                        vehicle.getChassi(), vehicle.getRentalValue(), vehicle.getBrand()));
            }
            return ResponseEntity.ok(vehicleDTOList);
        }
        else {
            return ResponseEntity.noContent().build();
        } */
    }

    @DeleteMapping("/vehicles/{id}")
    @PreAuthorize("hasRole('admin')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteVehicleById(@PathVariable Long id) {
        Optional<Vehicle> vehicleFound = vehicleService.findById(id);

        if (vehicleFound.isPresent()) {
            Vehicle vehicle = vehicleFound.get();
            vehicleService.delete(vehicle);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Vehicle " + vehicle.getId() + " " + vehicle.getBrand().getNameBrand() + " deleted successfully!");
        }
        else {
            throw  new RuntimeException("Vehicle not found.");
        }
    }
}
