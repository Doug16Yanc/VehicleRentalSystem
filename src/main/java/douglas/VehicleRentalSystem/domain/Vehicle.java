package douglas.VehicleRentalSystem.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id", unique = true)
    private Long id;

    @Column(name = "plate_number", unique = true)
    private int plateNumber;

    @Column(name = "color")
    private String color;

    @Column(name = "year")
    private int year;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "doors_number")
    private int doorsNumber;

    @Column(name = "mileage")
    private Double mileage;

    @Column(name = "renavam", unique = true)
    private Long renavam;

    @Column(name = "chassi", unique = true)
    private String chassi;

    @Column(name = "rental_value", unique = true)
    private Double rentalValue;

    @Embedded
    private Brand brand;

    public Vehicle() {

    }

    public Vehicle(int plateNumber, String color, int year, String fuelType, int doorsNumber, Double mileage, Long renavam, String chassi, Double rentalValue, Brand brand) {
        this.plateNumber = plateNumber;
        this.color = color;
        this.year = year;
        this.fuelType = fuelType;
        this.doorsNumber = doorsNumber;
        this.mileage = mileage;
        this.renavam = renavam;
        this.chassi = chassi;
        this.rentalValue = rentalValue;
        this.brand = brand;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(int plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getDoorsNumber() {
        return doorsNumber;
    }

    public void setDoorsNumber(int doorsNumber) {
        this.doorsNumber = doorsNumber;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public Long getRenavam() {
        return renavam;
    }

    public void setRenavam(Long renavam) {
        this.renavam = renavam;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Double getRentalValue() {
        return rentalValue;
    }

    public void setRentalValue(Double rentalValue) {
        this.rentalValue = rentalValue;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
