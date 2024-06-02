package douglas.VehicleRentalSystem.controller;

import douglas.VehicleRentalSystem.controller.dto.DevolutionDTO;
import douglas.VehicleRentalSystem.domain.Devolution;
import douglas.VehicleRentalSystem.domain.Rental;
import douglas.VehicleRentalSystem.service.DevolutionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class DevolutionController {

    private final DevolutionService devolutionService;

    public DevolutionController(DevolutionService devolutionService) {
        this.devolutionService = devolutionService;
    }

    @PostMapping("/devolutions")
    @PreAuthorize("hasRole('basic')")
    public ResponseEntity<String> toSaveDevolution(@RequestBody DevolutionDTO devolutionDTO) {
        var devolution = devolutionService.saveDevolution(devolutionDTO);

        return ResponseEntity.status(HttpStatus.OK).body("Devolution " + devolution.getId() + " saved successfully.");
    }

    @GetMapping("/devolutions/{id}")
    public ResponseEntity<Devolution> findDevolutionById(@PathVariable("id") UUID id) {
        Optional<Devolution> devolutionFound = this.devolutionService.findById(id);

        if (devolutionFound.isPresent()) {
            Devolution devolution = devolutionFound.get();
            return ResponseEntity.ok(devolution);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/devolutions/{id}")
    @PreAuthorize("hasRole('basic')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteDevolutionlById(@PathVariable UUID id) {
        Optional<Devolution>  devolutionFound = devolutionService.findById(id);

        if (devolutionFound.isPresent()) {
            Devolution devolution = devolutionFound.get();
            devolutionService.delete(devolution);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Region " + devolution.getId() + " by " + devolution.getUser().getUserId() +
                    " deleted successfully!" );
        }
        else {
            throw new RuntimeException("Rental data not found.");
        }
    }
}


