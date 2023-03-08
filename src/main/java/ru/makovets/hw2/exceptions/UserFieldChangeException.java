package ru.makovets.hw2.exceptions;

/**
 * Исключения при создании нового пользователя или редактировании полей существующего
 */
public class UserFieldChangeException extends RuntimeException {

    public UserFieldChangeException(String message) {
        super(message);
    }
}
