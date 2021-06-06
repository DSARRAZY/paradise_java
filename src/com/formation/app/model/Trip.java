package com.formation.app.model;

public class Trip {

    private Long id;
    private Place departure;
    private Place destination;
    private float price;


    public Trip() {
    }

    public Trip(Long id, Float price, String destination, String departure) {
    }

    public Place getDeparture() {

        return departure;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Place getDestination() {

        return destination;
    }

    public void setDestination(Place destination) {

        this.destination = destination;
    }

    public  float getPrice() {

        return price;
    }

    public void setPrice(Float price) {

        this.price = price;
    }

    public void setDeparture(Place departure) {

        this.departure = departure;
    }

}
