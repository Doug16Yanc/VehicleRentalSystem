package douglas.VehicleRentalSystem.repository;

import douglas.VehicleRentalSystem.domain.Devolution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DevolutionRepository extends JpaRepository<Devolution, UUID> {
}
