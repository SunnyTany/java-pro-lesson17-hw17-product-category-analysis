package app;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Coffee Maker", "Appliances", 80.0),
                new Product("Headphones", "Electronics", 150.0),
                new Product("Blender", "Appliances", 50.0),
                new Product("Smartphone", "Electronics", 800.0),
                new Product("Toaster", "Appliances", 40.0)
        );

        Map<String, Double> averagePricesByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.averagingDouble(Product::getPrice)
                ));

        System.out.printf("Average prices by category: %s%n", averagePricesByCategory);

        // Search and formatted output of the maximum category
        averagePricesByCategory.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(maxCategory -> {
                    System.out.printf("%nCategory with the highest average price:%n");
                    System.out.printf("Category: %s%n", maxCategory.getKey());
                    System.out.printf("Average Price: %.2f%n", maxCategory.getValue());
                });
    }
}