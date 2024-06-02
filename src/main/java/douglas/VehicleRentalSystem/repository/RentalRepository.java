package douglas.VehicleRentalSystem.repository;

import douglas.VehicleRentalSystem.domain.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface RentalRepository extends JpaRepository<Rental, UUID> {
}
