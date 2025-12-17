package cl.duoc.ms_users_bff.controller;

import cl.duoc.ms_users_bff.model.UserDto;
import cl.duoc.ms_users_bff.service.UserBffService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import feign.FeignException;
import java.util.Map;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/bff/users")
public class UserBffController {
    @Autowired
    private UserBffService userBffService;

    private static final Logger log = LoggerFactory.getLogger(UserBffController.class);

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userBffService.createUser(userDto));
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userBffService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id) {
        UserDto user = userBffService.getUserById(id);
        if (user == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        if (id == null || id <= 0 || userDto == null) return ResponseEntity.badRequest().build();
        log.debug("BFF PUT /bff/users/{} received DTO: {}", id, userDto);
        try {
            UserDto updated = userBffService.updateUser(id, userDto);
            log.debug("BFF updated result: {}", updated);
            return ResponseEntity.ok(updated);
        } catch (FeignException fe) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userBffService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        if (username == null || password == null) return ResponseEntity.badRequest().build();

        UserDto user = userBffService.login(username, password);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
