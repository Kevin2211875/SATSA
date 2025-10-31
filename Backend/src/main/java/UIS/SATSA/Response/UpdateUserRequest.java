package UIS.SATSA.Response;

public record UpdateUserRequest(
        String name,
        String apellidos,
        String correo,
        String contrasena,
        String telefono
) {
}