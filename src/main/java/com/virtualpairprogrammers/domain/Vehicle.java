package com.virtualpairprogrammers.domain;


import java.util.Objects;

public class Vehicle
{
    private Integer idVehicle;
    private String brand;
    private String model;
    private String fuel;


    public Vehicle(Integer idVehicle, String brand, String model, String fuel)
    {
        this.idVehicle = idVehicle;
        this.brand = brand;
        this.model = model;
        this.fuel = fuel;

    }

    public Integer getIdVehicle() {
        return idVehicle;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(idVehicle, vehicle.idVehicle) &&
                Objects.equals(brand, vehicle.brand) &&
                Objects.equals(model, vehicle.model) &&
                Objects.equals(fuel, vehicle.fuel);
    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (fuel != null ? fuel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return " brand: " + brand +
                "\n model: " + model  +
                "\n fuel: "+ fuel +
                "\n";
    }
}
