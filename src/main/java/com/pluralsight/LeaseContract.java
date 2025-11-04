package com.pluralsight;

public class LeaseContract extends Contract {

    public LeaseContract(String date, String name, String email, Vehicle vehicle) {
        super(date, name, email, vehicle);
    }

    @Override
    public double getTotalPrice() {
        double leaseFee = getVehicle().getPrice() * 0.07;
        return (getVehicle().getPrice() * 0.50) + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        double amount = getTotalPrice();
        double rate = 0.04 / 12;
        int months = 36;

        return (rate * amount) / (1 - Math.pow(1 + rate, -months));
    }
}
