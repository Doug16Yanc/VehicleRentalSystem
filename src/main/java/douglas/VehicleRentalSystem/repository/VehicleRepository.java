package douglas.VehicleRentalSystem.repository;

import douglas.VehicleRentalSystem.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
