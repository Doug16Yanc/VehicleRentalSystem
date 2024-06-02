package douglas.VehicleRentalSystem.repository;

import douglas.VehicleRentalSystem.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
