package com.company;

public abstract class Products {
    protected boolean availability;
    protected double price;
    protected double calories;
    protected String name;
    public Products()
    {
        this.availability=true;
    }
    public Products(double calories, double price, String name)
    {
        this.availability=true;
        this.calories=calories;
        this.price=price;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getComposition(){
        return this.getComposition();
    };
    public int getId()
    {
        return this.getId();
    }
    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Products{" +
                "availability=" + availability +
                ", price=" + price +
                ", calories=" + calories +
                '}';
    }
}