package com.car.domain;

public class Car {
    private CarName name;
    private MovingDistance movingDistance;

    public Car(String name) {
        this.name = new CarName(name);
        this.movingDistance = new MovingDistance();
    }

    public void move() {
        movingDistance.move();
    }

    public MovingDistance getMovingDistance() {
        return movingDistance;
    }

    public CarName getName() {
        return name;
    }
}
