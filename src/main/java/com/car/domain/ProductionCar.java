package com.car.domain;

import org.springframework.util.StringUtils;

public class ProductionCar {
    private String name;
    private int movingDistance;

    public ProductionCar(String name) {
        validateCarName(name);

        this.name = name;
        this.movingDistance = 0;
    }

    public void move() {
        if (movingDistance >= 10) {
            return;
        }

        movingDistance++;
    }

    public String getName() {
        return name;
    }

    public int getMovingDistance() {
        return movingDistance;
    }

    private void validateCarName(String name) {
        if (!StringUtils.hasLength(name) || name.length() > 5) {
            throw new IllegalArgumentException(
                String.format("자동차 이름은 1~5자 이어야합니다. name=%s", name)
            );
        }
    }
}
