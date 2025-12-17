package cl.duoc.ms_users_bff.client;

import cl.duoc.ms_users_bff.model.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

import java.util.List;

@FeignClient(name = "users-bs", url = "${ms-users-bs.url:http://localhost:8082}")
public interface UserBsClient {
    @PostMapping("/users")
    UserDto createUser(@RequestBody UserDto userDto);

    @GetMapping("/users")
    List<UserDto> getAllUsers();

    @GetMapping("/users/{id}")
    UserDto getUserById(@PathVariable("id") Long id);

    @PutMapping("/users/{id}")
    UserDto updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto);

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable("id") Long id);

    @PostMapping("/users/login")
    UserDto login(@RequestBody Map<String, String> credentials);
}
