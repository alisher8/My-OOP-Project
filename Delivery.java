package com.company;
import java.util.concurrent.atomic.AtomicInteger;//library for autoincrementing the id
public class Delivery {
    private int id;
    private String address;
    private static final AtomicInteger countdil = new AtomicInteger(0);
    public Delivery(){
        this.id=countdil.incrementAndGet();
    }
    public Delivery(String address){
        this.address=address;
        this.id=countdil.incrementAndGet();
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

}