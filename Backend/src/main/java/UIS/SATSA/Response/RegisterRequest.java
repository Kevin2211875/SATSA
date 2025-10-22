package UIS.SATSA.Response;

public record RegisterRequest(
        String name,
        String codigo,
        String apellidos,
        String correo,
        String contrasena,
        String telefono,
        Integer programa,
        Integer rol
) {
}