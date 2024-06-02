package douglas.VehicleRentalSystem.service;

import douglas.VehicleRentalSystem.domain.Role;
import douglas.VehicleRentalSystem.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<Role> findById(Long id) {
        var user = roleRepository.findById(id);

        return user;
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
