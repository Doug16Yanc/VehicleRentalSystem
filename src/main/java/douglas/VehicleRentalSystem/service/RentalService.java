package douglas.VehicleRentalSystem.service;

import douglas.VehicleRentalSystem.controller.dto.RentalDTO;
import douglas.VehicleRentalSystem.domain.Rental;
import douglas.VehicleRentalSystem.domain.Vehicle;
import douglas.VehicleRentalSystem.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RentalService {
    @Autowired
    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public Rental saveRental(RentalDTO rentalDTO) {
        return rentalRepository.save(rentalDTO.doRental());
    }

    public Optional<Rental> findById(UUID id){
        return rentalRepository.findById(id);
    }

    public void delete (Rental rental) {
        rentalRepository.delete(rental);
    }
}
