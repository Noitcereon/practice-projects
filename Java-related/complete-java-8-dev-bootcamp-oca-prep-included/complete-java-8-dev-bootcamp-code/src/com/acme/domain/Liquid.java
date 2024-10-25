package com.acme.domain;


public class Liquid extends Good {

    private double radius;

    public Liquid(String name, int modelNumber, double height, UnitOfMeasureType unitOfMeasure, boolean flammable, double weightPerUnitOfMeasure, double radius) {
        super(name, modelNumber, height, unitOfMeasure, flammable, weightPerUnitOfMeasure);
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double volume() {
        return Math.PI * radius * radius * getHeight();
    }

    @Override
    public String toString() {
        return super.toString() + " (liquid) " + volume() + " "
                + getUnitOfMeasure();
    }
}
