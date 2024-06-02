package douglas.VehicleRentalSystem.config;

import douglas.VehicleRentalSystem.domain.Address;
import douglas.VehicleRentalSystem.domain.User;
import douglas.VehicleRentalSystem.domain.Role;
import douglas.VehicleRentalSystem.service.RoleService;
import douglas.VehicleRentalSystem.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@Configuration
public class AdminUserConfig implements CommandLineRunner {

    private final RoleService roleService;
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AdminUserConfig(RoleService roleService, UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.roleService = roleService;
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        var roleAdmin = roleService.findByName(Role.Values.ADMIN.name());

        if (roleAdmin == null) {
            System.out.println("Not found.");
            return;
        }
        var userAdmin = userService.findByUserName("admin");

        userAdmin.ifPresentOrElse(
                user -> {
                    System.out.println("Admin already exists.");
                },
                () -> {
                    var user = new User("admin", "1609", new Address("here", 1609, 2000, "in this place", "in this local", "12345"), Set.of(roleAdmin));
                    userService.saveUser(user);

                }
        );
    }
}
