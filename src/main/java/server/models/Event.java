package server.models;

public class Event {

    private int idEvent;
    private int price;
    private int profit;
    private int idUser;

    public Event(int idEvent, int price, int profit, int idUser) {
        this.idEvent = idEvent;
        this.price = price;
        this.profit = profit;
        this.idUser = idUser;

    }

    public Event() {

    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }


}
