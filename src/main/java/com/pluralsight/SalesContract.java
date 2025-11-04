package com.pluralsight;

public class SalesContract extends Contract {

    private static final double SALES_TAX_RATE = 0.05;
    private static final double RECORDING_FEE = 100.0;
    private double processingFee;
    private boolean finance;

    public SalesContract(String date, String name, String email, Vehicle vehicle, boolean finance) {
        super(date, name, email, vehicle);
        this.finance = finance;
        this.processingFee = (vehicle.getPrice() < 10000) ? 295 : 495;
    }

    @Override
    public double getTotalPrice() {
        double tax = getVehicle().getPrice() * SALES_TAX_RATE;
        return getVehicle().getPrice() + tax + RECORDING_FEE + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!finance) return 0;

        double price = getTotalPrice();
        double rate;
        int months;

        if (price >= 10000) {
            rate = 0.0425 / 12;
            months = 48;
        } else {
            rate = 0.0525 / 12;
            months = 24;
        }

        return (rate * price) / (1 - Math.pow(1 + rate, -months));
    }
}