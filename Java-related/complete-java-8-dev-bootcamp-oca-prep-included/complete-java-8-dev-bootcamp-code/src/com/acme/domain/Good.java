package com.acme.domain;

import java.util.List;

public class Good {

    public enum UnitOfMeasureType {
        LITER, GALLON, CUBIC_METER,
        CUBIC_FEET
    }

    private String name;
    private int modelNumber;
    private double height;
    private UnitOfMeasureType unitOfMeasure;
    private boolean flammable = true;
    private double weightPerUnitOfMeasure;
    private static List<Good> catalogue;
// Below is part of Lab15_Collections, which required adding Lab09_Inheritance
//    static {
//        catalogue = Arrays.asList(
//                Liquid glue = new Liquid("Acme Glue", 2334, 4, UnitOfMeasureType.LITER, false, 15, 6),
//        Liquid paint = new Liquid("Acme Invisible Paint", 2490, 0.65, UnitOfMeasureType.GALLON, true, 0.70, 12),
//        Solid anvil = new Solid("Acme Anvil", 1668, 0.3, UnitOfMeasureType.CUBIC_METER, false, 500, 0.25, 0.3),
//        Solid safe = new Solid("Acme Safe", 1672, 1.0, UnitOfMeasureType.CUBIC_METER, false, 300, 0.5, 0.5),
//        Solid balloon = new Solid("Acme Balloon", 1401, 15, UnitOfMeasureType.CUBIC_FEET, false, 10, 5, 5),
//        Solid pistol = new Solid("Acme Disintegrating Pistol", 1587, 0.1, UnitOfMeasureType.CUBIC_FEET, false, 1, 0.5, 2),
//        Liquid nitro = new Liquid("Acme Nitroglycerin", 4289, 1.0, UnitOfMeasureType.CUBIC_METER, true, 1.5, 0.25),
//        Liquid oil = new Liquid("Acme Oil", 4275, 1.0, UnitOfMeasureType.CUBIC_METER, true, 1.5, 0.25)
//        );
//    }
    public Good(String name, int modelNumber, double height, UnitOfMeasureType unitOfMeasure, boolean flammable, double weightPerUnitOfMeasure) {
        this.name = name;
        this.modelNumber = modelNumber;
        this.height = height;
        this.unitOfMeasure = unitOfMeasure;
        this.flammable = flammable;
        this.weightPerUnitOfMeasure = weightPerUnitOfMeasure;
    }

    public static List<Good> getCatalogue() {
        return catalogue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public UnitOfMeasureType getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasureType unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public boolean isFlammable() {
        return flammable;
    }

    public void setFlammable(boolean flammable) {
        this.flammable = flammable;
    }

    public double getWeightPerUnitOfMeasure() {
        return weightPerUnitOfMeasure;
    }

    public void setWeightPerUnitOfMeasure(double weightPerUnitOfMeasure) {
        this.weightPerUnitOfMeasure = weightPerUnitOfMeasure;
    }

    public double volume() {
        return 0.0;
    }
    public double weight() {
        return volume() * weightPerUnitOfMeasure;
    }

    public static void setCatalogue(List<Good> catalogue) {
        Good.catalogue = catalogue;
    }
    public String toString() {
        return getName() + "-" + getModelNumber();
    }
}
