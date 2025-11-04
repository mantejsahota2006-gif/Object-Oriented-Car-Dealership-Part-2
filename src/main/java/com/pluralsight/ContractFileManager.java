package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ContractFileManager {
    private static final String FILE_NAME = "contracts.csv";

    public void saveContract(Contract contract) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {

            Vehicle v = contract.getVehicle();

            if (contract instanceof SalesContract sc) {
                writer.printf("SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f%n",
                        sc.getDate(), sc.getCustomerName(), sc.getCustomerEmail(),
                        v.getVin(), v.getYear(), v.getMake(), v.getModel(), v.getVehicleType(), v.getColor(),
                        v.getOdometer(), v.getPrice(), sc.getTotalPrice(), sc.getMonthlyPayment()
                );
            } else if (contract instanceof LeaseContract lc) {
                writer.printf("LEASE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f%n",
                        lc.getDate(), lc.getCustomerName(), lc.getCustomerEmail(),
                        v.getVin(), v.getYear(), v.getMake(), v.getModel(), v.getVehicleType(), v.getColor(),
                        v.getOdometer(), v.getPrice(), lc.getTotalPrice(), lc.getMonthlyPayment()
                );
            }

        } catch (IOException e) {
            System.out.println("Error saving contract: " + e.getMessage());
        }
    }
}