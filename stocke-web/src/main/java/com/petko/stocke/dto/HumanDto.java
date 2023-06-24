package com.petko.stocke.dto;

public class HumanDto {

    private long id;
    private String lastname;
    private String firstname;
    private String middlename;
    private String birthdate;
    private String snils;
    private String town;
    private String street;
    private String house;
    private String flat;
    private double square;
    private double coefficient;

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    private int storeys;
    private double remainder;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getStoreys() {
        return storeys;
    }

    public void setStoreys(int storeys) {
        this.storeys = storeys;
    }

    public double getRemainder() {
        return remainder;
    }

    public void setRemainder(double remainder) {
        this.remainder = remainder;
    }

    public HumanDto(long id, String lastname, String firstname, String middlename, String birthdate, String snils, String town, String street, String house, String flat, double square, double coefficient, int storeys, double remainder) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.middlename = middlename;
        this.birthdate = birthdate;
        this.snils = snils;
        this.town = town;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.square = square;
        this.coefficient = coefficient;
        this.storeys = storeys;
        this.remainder = remainder;
    }
}
