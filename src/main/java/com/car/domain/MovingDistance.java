package com.car.domain;

import java.util.Objects;

public class MovingDistance {
    private int id;
    private int distance;

    public MovingDistance() {
        this.distance = 0;
    }

    protected MovingDistance(int distance) {
        this.distance = distance;
    }

    public void move() {
        if (distance >= 10) {
            return;
        }

        distance++;
    }

    @Override
    public boolean equals(Object o) {
        MovingDistance that = (MovingDistance)o;
        return distance == that.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, distance);
    }
}
