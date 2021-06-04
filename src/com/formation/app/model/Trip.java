package com.formation.app.model;

public class Trip {

    private Long id;
    private String departure;
    private String destination;
    private float price;


    public Trip() {

    }

    public String getDeparture() {
        return departure;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public  float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

}
