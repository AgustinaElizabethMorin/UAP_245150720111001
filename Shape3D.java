package uap.bases;

import uap.interfaces.Calculable;
import uap.interfaces.Convertible;
import uap.interfaces.Displayable;

public abstract class Shape3D implements Calculable, Convertible, Displayable {
    protected static final double PI = 22.0 / 7.0;
    protected static final double DENSITY_STAINLESS_STEEL_304 = 8.0; // g/cm³
    protected static final double THICKNESS = 0.5; // cm
    protected static final int SHIPPING_COST_PER_KG = 5000; // Rp per kg
    
    protected double volume;
    protected double surfaceArea;
    protected double mass;
    
    // Abstract methods yang harus diimplementasi oleh subclass
    public abstract double calculateVolume();
    public abstract double calculateSurfaceArea();
    
    @Override
    public double calculateMass() {
        // Massa = Volume × Density
        this.mass = calculateVolume() * DENSITY_STAINLESS_STEEL_304;
        return this.mass;
    }
    
    @Override
    public double convertToKilogram() {
        return calculateMass() / 1000.0;
    }
    
    @Override
    public int calculateShippingCost() {
        double massInKg = convertToKilogram();
        int roundedKg = (int) Math.ceil(massInKg); // Bulatkan ke atas
        return roundedKg * SHIPPING_COST_PER_KG;
    }
    
    @Override
    public void printInfo() {
        System.out.println("Volume : " + String.format("%.2f", calculateVolume()) + " cm³");
        System.out.println("Luas permukaan : " + String.format("%.2f", calculateSurfaceArea()) + " cm²");
        System.out.println("Massa : " + String.format("%.2f", calculateMass()) + " gr");
        System.out.println("Massa dalam kg : " + String.format("%.3f", convertToKilogram()) + " kg");
        System.out.println("Biaya kirim : Rp" + calculateShippingCost());
    }
}

