package ru.makovets.hw2.exceptions;

/**
 * Объект БД не найден
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
