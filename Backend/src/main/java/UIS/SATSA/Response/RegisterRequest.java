package UIS.SATSA.Response;

public record RegisterRequest(
        String name,
        String apellidos,
        String correo,
        String contrasena,
        String telefono
) {
}