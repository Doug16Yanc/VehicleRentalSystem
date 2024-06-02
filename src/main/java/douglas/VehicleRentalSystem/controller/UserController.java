package douglas.VehicleRentalSystem.controller;

import douglas.VehicleRentalSystem.controller.dto.UserDTO;
import douglas.VehicleRentalSystem.domain.Address;
import douglas.VehicleRentalSystem.domain.Role;
import douglas.VehicleRentalSystem.domain.User;
import douglas.VehicleRentalSystem.service.RoleService;
import douglas.VehicleRentalSystem.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@RestController
public class UserController {

    private final UserService userService;
    private final RoleService roleService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserService userService, RoleService roleService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Transactional
    @PostMapping("/users")
    public ResponseEntity<String> newUser(@RequestBody UserDTO userDTO){

        var basicRole = roleService.findByName(Role.Values.BASIC.name());

        var userFromDb = userService.findByUserName(userDTO.username());

        if (userFromDb.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        var user = new User(userDTO.username(), bCryptPasswordEncoder.encode(userDTO.password()), new Address(), Set.of(basicRole));

        userService.saveUser(user);

        return ResponseEntity.status(HttpStatus.OK).body("User " + user.getUserId() + " saved successfully.");

    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<List<User>> listUsers() {
        var users = userService.findAll();

        return ResponseEntity.ok(users);
    }
}
