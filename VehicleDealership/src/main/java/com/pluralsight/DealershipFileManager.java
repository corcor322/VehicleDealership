package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class DealershipFileManager {

    public Dealership getDealership() {
        Dealership dealership = null;
        try (BufferedReader br = new BufferedReader(new FileReader("dealership.csv"))) {
            String line;
            while ((line = br.readLine()) != null)) {
                String[] values = line.split("\\|");
                if (dealership == null && values.length == 3) {
                    dealership = new Dealership(values[0], values[1], values[2]);

                } else if (values.length == 8) {

                }
            }
        } catch

    }
    public void saveDealership() {

    }
}
