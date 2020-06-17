package com.infoshareacademy.events;

public class Organizer {
    private String id;
    private String designation;

    public Organizer(String id, String designation) {
        this.id = id;
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Organizer " +
                "id = " + id +
                ", designation = " + designation ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
