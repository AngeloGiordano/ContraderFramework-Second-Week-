package com.virtualpairprogrammers.domain;

public class Gomma {

    private Integer idGomme;
    private String model;
    private String manufacturer;
    private double price;


    public Gomma(Integer idGomme, String model, String manufacturer, double price)
    {
        this.idGomme = idGomme;
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
    }


    public Integer getIdGomme() {
        return idGomme;
    }



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gomma gomma = (Gomma) o;

        if (Double.compare(gomma.price, price) != 0) return false;
        if (model != null ? !model.equals(gomma.model) : gomma.model != null) return false;
        return manufacturer != null ? manufacturer.equals(gomma.manufacturer) : gomma.manufacturer == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = model != null ? model.hashCode() : 0;
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Gomma" +
                "model:'" + model + '\'' +
                "\n manufacturer:'" + manufacturer + '\'' +
                "\nprice:" + price +
                '\n';
    }
}
