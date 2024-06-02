package douglas.VehicleRentalSystem.controller.dto;

public record LoginResponse(
        String accessToken,
        Long expireIn
) {
}
