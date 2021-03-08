package com.company;

import java.util.concurrent.atomic.AtomicInteger;
public class Drinks extends Products {
    protected double volume;
    protected boolean aerated;
    protected boolean alcoholic;
    protected int id;
    protected String name;
    private static final AtomicInteger countdrinks = new AtomicInteger(2);
    public Drinks()
    {
        this.id=countdrinks.incrementAndGet();
    }
    public Drinks(double volume, boolean aerated, boolean alcoholic)
    {
        this.aerated=aerated;
        this.id=countdrinks.incrementAndGet();
        this.alcoholic=alcoholic;
        this.volume=volume;
    }

    @Override
    public String getName() {
        return name;
    }

    public Drinks(double volume, boolean aerated, boolean alcoholic,  double calories, double price,String name)
    {
        this.aerated=aerated;
        this.id=countdrinks.incrementAndGet();
        this.alcoholic=alcoholic;
        this.volume=volume;
        this.availability=true;
        this.calories=calories;
        this.price=price;
        this.name = name;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setAerated(boolean aerated) {
        this.aerated = aerated;
    }


    public boolean isAerated() {
        return aerated;
    }

    public void setAlcoholic(boolean alcoholic) {
        this.alcoholic = alcoholic;
    }

    public boolean isAlcoholic() {
        return alcoholic;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "volume=" + volume +
                ", aerated=" + aerated +
                ", alcoholic=" + alcoholic +
                ", id=" + id +
                '}';
    }
}