package org.tradingpit.demo.rest.register;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tradingpit.demo.rest.register.dto.ClientDto;
import org.tradingpit.demo.rest.register.dto.ClientSaveDto;

@Tag(name = "register", description = "Register a new clients")
@RestController
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterFacade facade;

    @PostMapping("/register/client")
    public ResponseEntity<ClientDto> registerClient(@RequestBody ClientSaveDto clientSaveDto) {
        return ResponseEntity.ok(facade.register(clientSaveDto));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ClientDto> handleException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
    }
}
