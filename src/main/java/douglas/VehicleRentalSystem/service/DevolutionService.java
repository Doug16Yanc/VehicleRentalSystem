package douglas.VehicleRentalSystem.service;

import douglas.VehicleRentalSystem.controller.dto.DevolutionDTO;
import douglas.VehicleRentalSystem.controller.dto.RentalDTO;
import douglas.VehicleRentalSystem.domain.Devolution;
import douglas.VehicleRentalSystem.domain.Rental;
import douglas.VehicleRentalSystem.repository.DevolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DevolutionService {

    @Autowired
    private final DevolutionRepository devolutionRepository;


    public DevolutionService(DevolutionRepository devolutionRepository) {
        this.devolutionRepository = devolutionRepository;
    }

    public Devolution saveDevolution(DevolutionDTO devolutionDTO) {
        return devolutionRepository.save(devolutionDTO.doDevolution());
    }

    public Optional<Devolution> findById(UUID id){
        return devolutionRepository.findById(id);
    }

    public void delete (Devolution devolution) {
        devolutionRepository.delete(devolution);
    }

}
