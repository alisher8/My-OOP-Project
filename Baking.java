package com.company;

import java.util.concurrent.atomic.AtomicInteger;

public class Baking extends Products {
    protected String composition;
    protected int id;
    protected String name;
    private static final AtomicInteger countbaking = new AtomicInteger(6);
    public Baking()
    {
        this.id=countbaking.incrementAndGet();
    }
    public Baking(String composition)
    {
        this.composition=composition;
        this.id=countbaking.incrementAndGet();
    }
    public Baking(String composition,double calories,double price, String name)
    {
        this.composition=composition;
        this.availability=true;
        this.calories=calories;
        this.price=price;
        this.id=countbaking.incrementAndGet();
        this.name=name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getComposition() {
        return composition;
    }

    public int getId() {
        return this.id;
    }


    @Override
    public String toString() {
        return "Baking{" +
                "composition='" + composition + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

