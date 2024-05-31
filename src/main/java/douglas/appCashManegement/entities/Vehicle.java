package douglas.appCashManegement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_vehicles")
public class Vehicle {
    private Long id;

    private int plateNumber;

    private String color;

    private int year;
}
