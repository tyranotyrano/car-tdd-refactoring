package com.car.domain;

import java.util.Objects;

import org.springframework.util.StringUtils;

public class CarName {
    private String name;

    public CarName(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        if (!StringUtils.hasLength(name) || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1~5자만 가능하다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CarName carName = (CarName)o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
