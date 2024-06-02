INSERT IGNORE INTO tb_roles (id, role_name) VALUES (1, "admin");
INSERT IGNORE INTO tb_roles (id, role_name) VALUES (2, "basic");
INSERT IGNORE INTO tb_roles (id, role_name) VALUES (3, "admin");

INSERT IGNORE INTO tb_vehicles (plate_number, color, year, fuel_type, doors_number, mileage, renavam, chassi, rental_value, name_brand, nationality_brand, name_model)
VALUES
    (1234, 'Red', 2022, 'Gasoline', 4, 10000.5, 12345678901, 'ABC123456', 1500.0, 'Toyota', 'Japan', 'Hilux'),
    (5678, 'Blue', 2020, 'Diesel', 5, 20000.7, 98765432109, 'DEF987654', 1800.0, 'Ford', 'USA', 'Ford');
