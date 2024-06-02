package douglas.VehicleRentalSystem.domain;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_devolutions")
public class Devolution {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "devolution_id", unique = true)
    private UUID id;

    @Column(name = "devolution_time")
    @NotNull
    private LocalDateTime devolutionDateTime;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rental_id", nullable = false)
    private Rental rental;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_vehicles",
            joinColumns = @JoinColumn(name = "vehicle_id"),
            inverseJoinColumns = @JoinColumn(name = "devolution_id")
    )
    private Vehicle vehicle;

    public Devolution() {

    }
    public Devolution(UUID id, LocalDateTime devolutionDateTime, User user, Vehicle vehicle) {
        this.id = id;
        this.devolutionDateTime = devolutionDateTime;
        this.user = user;
        this.vehicle = vehicle;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDevolutionDateTime() {
        return devolutionDateTime;
    }

    public void setDevolutionDateTime(LocalDateTime devolutionDateTime) {
        this.devolutionDateTime = devolutionDateTime;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @PrePersist
    @PreUpdate
    private void validateDates() {
        if (devolutionDateTime != null && rental.getRentalDateTime() != null && !devolutionDateTime.isAfter(rental.getRentalDateTime())){
            throw new IllegalArgumentException("Devolution date and time must be after rental date and time");
        }
    }

}
