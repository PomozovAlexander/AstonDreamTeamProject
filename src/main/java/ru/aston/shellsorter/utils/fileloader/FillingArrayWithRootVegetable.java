package ru.aston.shellsorter.utils.fileloader;


import java.io.File;
import java.io.IOException;

import ru.aston.shellsorter.model.RootVegetable;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FillingArrayWithRootVegetable {
    private FillingArrayWithRootVegetable() {
        throw new UnsupportedOperationException("Utility class.");
    }
    
    public static RootVegetable[] buildRootVegetableArrayFromJson(int length) {
        try {
            if (length < 0) {
                throw new IllegalArgumentException("Array length must be non-negative.");
            }

            ObjectMapper objectMapper = new ObjectMapper();
            
            String fileName = FillingArrayWithRootVegetable.class.getClassLoader().getResource("inputdata/rootvegetable.json").getPath();
            
            RootVegetable[] rootVegetablesInJson = objectMapper.readValue(new File(fileName), RootVegetable[].class);

            if (length > rootVegetablesInJson.length) {
                throw new IllegalArgumentException("Requested length exceeds available data.");
            }

            RootVegetable[] RootVegetablesInArray = new RootVegetable[length];

            for (int i = 0; i < length; i++) {
                String type = rootVegetablesInJson[i].getType();  
                int weight = rootVegetablesInJson[i].getWeight();   
                String color = rootVegetablesInJson[i].getColor();     

                RootVegetablesInArray[i] = new RootVegetable.Builder()
                        .setType(type)
                        .setWeight(weight)
                        .setColor(color)
                        .build();
            }
            
            return RootVegetablesInArray;
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return new RootVegetable[0];  
        }
    }
}
