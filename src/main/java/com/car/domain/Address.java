package com.car.domain;

public class Address {
    private String nation;
    private String city;
    private int zipcode;

    public Address(String nation, String city, int zipcode) {
        this.nation = nation;
        this.city = city;
        this.zipcode = zipcode;
    }

    public static Address of(String nation, String city, int zipcode) {
        return new Address(nation, city, zipcode);
    }
}
