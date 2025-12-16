package cl.duoc.ms_users_bff.controller;

import cl.duoc.ms_users_bff.model.UserDto;
import cl.duoc.ms_users_bff.service.UserBffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bff/users")
public class UserBffController {
    @Autowired
    private UserBffService userBffService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userBffService.createUser(userDto));
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userBffService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto user = userBffService.getUserById(id);
        if (user == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userBffService.updateUser(id, userDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userBffService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
