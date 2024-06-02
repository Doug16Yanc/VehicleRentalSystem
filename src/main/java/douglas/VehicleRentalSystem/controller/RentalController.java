package douglas.VehicleRentalSystem.controller;

import douglas.VehicleRentalSystem.controller.dto.RentalDTO;
import douglas.VehicleRentalSystem.domain.Rental;
import douglas.VehicleRentalSystem.service.RentalService;
import org.hibernate.engine.spi.Resolution;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping("/rentals")
    @PreAuthorize("hasRole('basic')")
    public ResponseEntity<String> toSaveRental(@RequestBody RentalDTO rentalDTO) {
        var rental = rentalService.saveRental(rentalDTO);

        return ResponseEntity.status(HttpStatus.OK).body("Devolution " + rental.getId() + " saved successfully.");

    }

    @GetMapping("/rentals/{id}")
    public ResponseEntity<Rental> findRentalById(@PathVariable("id")UUID id) {
        Optional<Rental> rentalFound = this.rentalService.findById(id);

        if (rentalFound.isPresent()) {
            Rental rental = rentalFound.get();
            return ResponseEntity.ok(rental);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/rentals/{id}")
    @PreAuthorize("hasRole('basic')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteRentalById(@PathVariable UUID id) {
        Optional<Rental> rentalFound = rentalService.findById(id);

        if (rentalFound.isPresent()) {
            Rental rental = rentalFound.get();
            rentalService.delete(rental);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Region " + rental.getId() + " by " + rental.getUser().getUserId() +
                   " deleted successfully!" );
        }
        else {
            throw new RuntimeException("Rental data not found.");
        }
    }
}
