package ru.makovets.hw2.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.makovets.hw2.model.UserDto;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequestMapping("${web.root}")
public interface RestControllerApi {

    @PostMapping("/user")
    ResponseEntity<UserDto> createNewUser(@RequestBody UserDto inUser);

    @GetMapping("/user/{userId}")
    ResponseEntity<UserDto> getUser(@PathVariable(name = "userId") long id);

    @GetMapping("/user")
    ResponseEntity<List<UserDto>> getAllUsers();

    @DeleteMapping("/user/{userId}")
    ResponseEntity<Map<String, Object>> deleteUser(@PathVariable(name = "userId") long id);

    @PutMapping("/user/{userId}")
    ResponseEntity<UserDto> editUser(@PathVariable(name = "userId") long id, @RequestBody @Valid UserDto userDto);

    @PatchMapping("/user/{userId}")
    ResponseEntity<UserDto> partialEditUser(@PathVariable(name = "userId") long id, @RequestBody UserDto userDto);
}
