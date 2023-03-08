package ru.makovets.hw2.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.makovets.hw2.controller.api.RestControllerApi;
import ru.makovets.hw2.model.UserDto;
import ru.makovets.hw2.model.entities.User;
import ru.makovets.hw2.repository.UserRepository;
import ru.makovets.hw2.service.Utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RestControllerImpl implements RestControllerApi {

    private final UserRepository repository;
    private final Utils utils;

    @Override
    public ResponseEntity<UserDto> createNewUser(UserDto inUser) {
        utils.checkUserDtoFields(inUser);
        User user = new User(inUser);
        return ResponseEntity.ok(repository.save(user).toDTO());
    }

    @Override
    public ResponseEntity<UserDto> getUser(long id) {
        UserDto userDto = utils.getUserById(id).toDTO();
        return ResponseEntity.ok(userDto);
    }

    @Override
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(repository.findAll().stream()
                .sorted((u1, u2) -> Math.toIntExact(u1.getId() - u2.getId()))
                .map(User::toDTO)
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<Map<String, Object>> deleteUser(long id) {
        repository.delete(utils.getUserById(id));
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UserDto> editUser(long id, UserDto userDto) {
        userDto.setId(String.valueOf(id));
        utils.checkUserDtoFields(userDto);
        User user = utils.getUserById(id);
        user.copy(userDto);
        return ResponseEntity.ok(repository.save(user).toDTO());
    }

    @Override
    public ResponseEntity<UserDto> partialEditUser(long id, UserDto userDto) {
        userDto.setId(String.valueOf(id));
        utils.checkUserDtoFields(userDto);
        User user = utils.getUserById(id);
        user.merge(userDto);
        return ResponseEntity.ok(repository.save(user).toDTO());
    }
}