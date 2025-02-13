package ru.aston.shellsorter.utils.fileloader;

import java.io.File;
import java.io.IOException;

import ru.aston.shellsorter.model.Car;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FillingArrayWithCar {
    private FillingArrayWithCar() {
        throw new UnsupportedOperationException("Utility class.");
    }
    
    public static Car[] buildCarArrayFromJson(int length) {
        try {
            if (length < 0) {
                throw new IllegalArgumentException("Array length must be non-negative.");
            }

            ObjectMapper objectMapper = new ObjectMapper();
            
            String fileName = FillingArrayWithCar.class.getClassLoader().getResource("inputdata/car.json").getPath();
            
            Car[] carsInJson = objectMapper.readValue(new File(fileName), Car[].class);

            if (length > carsInJson.length) {
                throw new IllegalArgumentException("Requested length exceeds available data.");
            }

            Car[] carsInArray = new Car[length];

            for (int i = 0; i < length; i++) {
                int power = carsInJson[i].getPower();  
                String model = carsInJson[i].getModel();   
                int productionYear = carsInJson[i].getProductionYear();     

                carsInArray[i] = new Car.Builder()
                        .setPower(power)
                        .setModel(model)
                        .setProductionYear(productionYear)
                        .build();
            }
            
            return carsInArray;
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return new Car[0];  
        }
    }
}
