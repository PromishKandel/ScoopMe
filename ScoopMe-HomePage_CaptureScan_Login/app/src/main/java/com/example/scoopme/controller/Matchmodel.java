package com.example.scoopme.controller;

import java.io.Serializable;

public class Matchmodel implements Serializable {


    public Matchmodel(String startpoint, String destination) {
        this.startpoint = startpoint;
        this.destination = destination;
    }

    public String getStartpoint() {
        return startpoint;
    }

    public void setStartpoint(String startpoint) {
        this.startpoint = startpoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    private String startpoint;
    private String destination;


}
