package com.example.scoopme.controller;

import java.util.ArrayList;

public class Dispatcher {

    public ArrayList matches(String des, ArrayList<OfferEntityModel> offers){
        ArrayList output = new ArrayList();

        for(int i = 0; i < offers.size();i++){
            if (offers.get(i).getDestination().equals(des)){
                output.add(new Matchmodel(offers.get(i).getStartpoint(), offers.get(i).getDestination()));
            }
        }
        return output;
    }















}
