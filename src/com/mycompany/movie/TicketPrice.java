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
public abstract class TicketPrice {
    int quantity;
    
    public TicketPrice(int q) {
        quantity = q;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public abstract double calTicketPrice();
    public abstract double getPrice();
}

class Adult extends TicketPrice {
    double price = 10.00;
    
    public Adult(int q) {
        super(q);
    }
    
    public double calTicketPrice() {
        price = super.getQuantity()*price;
        return price;
    }
    public double getPrice() {
        return price;
    }
}

class Children extends TicketPrice {
    double price = 6.00;
    
    public Children(int q) {
        super(q);
    }
    
    public double calTicketPrice() {
        price = super.getQuantity()*price;
        return price;
    }
    public double getPrice() {
        return price;
    }
}

class OKU extends TicketPrice {
    double price = 8.00;
    
    public OKU(int q) {
        super(q);
    }
    
    public double calTicketPrice() {
        price = super.getQuantity()*price;
        return price;
    }
    public double getPrice() {
        return price;
    }
}

class Senior extends TicketPrice {
    double price = 8.00;
    
    public Senior(int q) {
        super(q);
    }
    
    public double calTicketPrice() {
        price = super.getQuantity()*price;
        return price;
    }
    public double getPrice() {
        return price;
    }
}

class Student extends TicketPrice {
    double price = 9.00;
    
    public Student(int q) {
        super(q);
    }
    
    public double calTicketPrice() {
        price = super.getQuantity()*price;
        return price;
    }
    public double getPrice() {
        return price;
    }
}