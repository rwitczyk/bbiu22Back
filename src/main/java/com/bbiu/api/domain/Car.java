package com.bbiu.api.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Car {

    private Long id;

    private String company;

    private String model;

    private Integer numberOfDoors;
}
