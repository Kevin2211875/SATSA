package UIS.SATSA.Controller;

import UIS.SATSA.Repository.UsuarioRepository;
import UIS.SATSA.Response.AuthRequest;
import UIS.SATSA.Response.RegisterRequest;
import UIS.SATSA.Response.TokenResponse;
import UIS.SATSA.Service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UsuarioController {

    private final AuthService service;
    private final UsuarioRepository repository;

    public UsuarioController(AuthService service, UsuarioRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping("/register")
    public ResponseEntity<TokenResponse> register(@RequestBody RegisterRequest request) {
        final TokenResponse response = service.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> authenticate(@RequestBody AuthRequest request) {
        final TokenResponse response = service.authenticate(request);
        return ResponseEntity.ok(response);
    }
}
