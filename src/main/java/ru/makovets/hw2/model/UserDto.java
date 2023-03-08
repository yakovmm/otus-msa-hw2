package ru.makovets.hw2.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class UserDto {

    private String id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
}
