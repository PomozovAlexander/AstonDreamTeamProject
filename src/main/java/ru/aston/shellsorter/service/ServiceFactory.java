package ru.aston.shellsorter.service;

import java.util.Map;

public final class ServiceFactory {
    private static final Map<String, Service> serviceOptions = Map.of(
            "Book", new BookService(),
            "Car", new CarService(),
            "Root Vegetable", new RootVegetableService()
    );
    private static Service actualService;
    private static String processedType;

    private ServiceFactory() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String getProcessedType() {
        return processedType;
    }

    public static Service getActualService() {
        return actualService;
    }

    public static void setActualService(String type) {
        if (actualService != null) {
            throw new UnsupportedOperationException("Actual Service must not be changed!");
        }
        if (!serviceOptions.containsKey(type)) {
            throw new IllegalArgumentException("No service found for key: " + type);
        }
        processedType = type;
        actualService = serviceOptions.get(type);
    }
}
