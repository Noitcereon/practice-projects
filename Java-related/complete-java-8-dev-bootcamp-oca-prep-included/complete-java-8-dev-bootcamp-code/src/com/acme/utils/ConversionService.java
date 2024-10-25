package com.acme.utils;

public class ConversionService {
    private ConversionService() {
        // To hide the implicit constructor.
    }
    // Weight conversion rates.
    /**
     * conversion rate for 1 kilogram to pounds
     */
    public static final double KILOGRAM_TO_POUNDS = 2.2046;
    /**
     * conversion rate for 1 kilogram to grams
     */
    public static final int KILOGRAM_TO_GRAMS = 1000;
    /**
     * conversion rate for 1 kilogram to weight ounces
     */
    public static final double KILOGRAM_TO_OUNCES = 35.274;

     // volume conversion rates
    /**
     * conversion rate for 1 liter to fluid ounces
     */
    public static final float LITER_TO_FLUID_OUNCE = 33.814f;
    /**
     * conversion rate for 1 liter to gallons
     */
    public static final float LITER_TO_GALLON = 0.2642f;
    /**
     * conversion rate for 1 liter to pints
     */
    public static final float LITER_TO_PINTS = 2.1134f;
    /**
     * Conversion rate for 1 liter to milliliters
     */
    public static final short LITERTO_MILLILITERS = 1_000;

    public static double pounds(double kilograms) {
        return kilograms * KILOGRAM_TO_POUNDS;
    }

    public static int grams(int kilograms) {
        return kilograms * KILOGRAM_TO_GRAMS;
    }

    public static double ounces(double kilograms) {
        return kilograms * KILOGRAM_TO_OUNCES;
    }

    public static float fluidOunces(float liters) {
        return liters * LITER_TO_FLUID_OUNCE;
    }

    public static float gallons(float liters) {
        return liters * LITER_TO_GALLON;
    }

    public static float pints(float liters) {
        return liters * LITER_TO_PINTS;
    }

    public static int milliliters(int liters) {
        return liters * LITERTO_MILLILITERS;
    }
}
