package com.example.scoopme.controller;

public class OfferEntityModel {

    private String Destination;
    private String Startpoint;


    public String getStartpoint() {
        return Startpoint;
    }

    public void setStartpoint(String startpoint) {
        this.Startpoint = startpoint;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
       this. Destination = destination;
    }

    private int id;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public OfferEntityModel(String startpoint, String destination) {
        this.Destination = destination;
        this.Startpoint = startpoint;
    }


}
