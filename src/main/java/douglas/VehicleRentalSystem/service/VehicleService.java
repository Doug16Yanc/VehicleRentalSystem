package douglas.VehicleRentalSystem.service;

import douglas.VehicleRentalSystem.controller.dto.VehicleDTO;
import douglas.VehicleRentalSystem.domain.Vehicle;
import douglas.VehicleRentalSystem.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle saveVehicle(VehicleDTO vehicleDTO){
        return vehicleRepository.save(vehicleDTO.doVehicle());
    }

    public Optional<Vehicle> findById(Long id){
        return vehicleRepository.findById(id);
    }

    public List<Vehicle> listVehicles() {
        return vehicleRepository.findAll();
    }

    public void delete (Vehicle vehicle) {
        vehicleRepository.delete(vehicle);
    }

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }
}
