package com.mycompany.database;

public class Seats {
    private String seat;
    private String status;

    public Seats(String seat, String status) {
        this.seat = seat;
        this.status = status;
    }

    // Getters and setters
    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
