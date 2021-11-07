package com.bbiu.api.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Car {

    private Long id;

    @NonNull
    private String company;

    @NonNull
    private String model;

    @NonNull
    private Integer numberOfDoors;
}
