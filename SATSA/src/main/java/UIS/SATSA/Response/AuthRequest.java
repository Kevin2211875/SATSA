package UIS.SATSA.Response;

public record AuthRequest(
        String email,
        String password
) {
}