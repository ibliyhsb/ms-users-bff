package cl.duoc.ms_blogs_bff.service;

import cl.duoc.ms_blogs_bff.model.UserDto;
import cl.duoc.ms_blogs_bff.client.UserBsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserBffService {
    @Autowired
    private UserBsClient userBsClient;

    public UserDto createUser(UserDto userDto) {
        return userBsClient.createUser(userDto);
    }

    public List<UserDto> getAllUsers() {
        return userBsClient.getAllUsers();
    }

    public UserDto getUserById(Long id) {
        return userBsClient.getUserById(id);
    }

    public UserDto updateUser(Long id, UserDto userDto) {
        return userBsClient.updateUser(id, userDto);
    }

    public void deleteUser(Long id) {
        userBsClient.deleteUser(id);
    }
}
