
package com.mycompany.movie;

public class TicketPrice 
{
    private int quantity;
    private int price;
    
    public TicketPrice(int quantity, int price) {
        this.quantity = quantity;
        this.price = price;
    }
    public int getQuantity()
    {
        return this.quantity;
    }

    public int getPrice() {
        return price;
    }
    public int getTotalPrice()
    {
        return price * quantity;
    }
    public String getTotalPriceToVND()
    {
        return String.valueOf(this.getTotalPrice()) + " VND";
    }
    
}

