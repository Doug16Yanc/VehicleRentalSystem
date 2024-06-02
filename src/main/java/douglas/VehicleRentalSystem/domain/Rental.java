package douglas.VehicleRentalSystem.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "rental_id", unique = true)
    private UUID id;

    @Column(name = "rental_time")
    private LocalDateTime rentalDateTime;

    private Double valueRental;

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

    public Rental() {

    }

    public Rental(UUID id, LocalDateTime rentalDateTime, Double valueRental, User user, Vehicle vehicle) {
        this.id = id;
        this.rentalDateTime = rentalDateTime;
        this.valueRental = valueRental;
        this.user = user;
        this.vehicle = vehicle;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getRentalDateTime() {
        return rentalDateTime;
    }

    public void setRentalDateTime(LocalDateTime rentalDateTime) {
        this.rentalDateTime = rentalDateTime;
    }

    public Double getValueRental() {
        return valueRental;
    }

    public void setValueRental(Double valueRental) {
        this.valueRental = valueRental;
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
}
