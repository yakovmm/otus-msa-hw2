package ru.makovets.hw2.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ResponseStatus {

    String status;
}
