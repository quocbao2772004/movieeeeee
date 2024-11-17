/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.movie;

/**
 *
 * @author muham
 */
public class Movie { // superclass
    protected String cinema;
    protected String movieName;
    protected String movieDate;
    protected String movieTime;
    protected String hall;
    protected String seat;
    protected String price;
    
    // default constructor
    
    public Movie() {
    
        cinema = "";
        movieName = "";
        movieDate = "";
        movieTime = "";
        hall = "";
        seat = "";
        price = "";
    }
    
    // mutator
    
    public void setCinema(String c) {
        cinema = c;
    }
    public void setMovieName(String mn) {
        movieName = mn;
    }
    public void setMovieDate(String d) {
        movieDate = d;
    }
    public void setMovieTime(String mt) {
        movieTime = mt;
    }
    public void setHall(String h) {
        hall = h;
    }
    public void setSeat(String s) {
        seat = s;
    }
    public void setPrice(String p) {
        price = p;
    }
    
    // accessor
    
    public String getCinema() {
        return cinema;
    }
    public String getMovieName() {
        return movieName;
    }
    public String getMovieDate() {
        return movieDate;
    }
    public String getMovieTime() {
        return movieTime;
    }
    public String getHall() {
        return hall;
    }
    public String getSeat() {
        return seat;
    }
    public String getPrice() {
        return price;
    }
}