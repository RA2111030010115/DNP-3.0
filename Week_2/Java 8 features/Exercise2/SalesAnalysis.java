import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class SalesAnalysis {
    public static void main(String[] args) {
        List<SalesRecord> salesRecords = Arrays.asList(
            new SalesRecord(1, "Alice", "North", 5000, LocalDate.of(2023, 1, 10)),
            new SalesRecord(2, "Bob", "South", 7000, LocalDate.of(2023, 1, 15)),
            new SalesRecord(3, "Charlie", "North", 6000, LocalDate.of(2023, 1, 20)),
            new SalesRecord(4, "David", "East", 8000, LocalDate.of(2023, 1, 25)),
            new SalesRecord(5, "Eve", "South", 9000, LocalDate.of(2023, 1, 30))
        );

        
        List<SalesRecord> northRegionSales = salesRecords.stream()
                .filter(record -> record.getRegion().equals("North"))
                .collect(Collectors.toList());

        System.out.println("Filtered Sales Records (North Region):");
        northRegionSales.forEach(System.out::println);

        
        List<Double> salesAmounts = northRegionSales.stream()
                .map(SalesRecord::getAmount)
                .collect(Collectors.toList());

        System.out.println("\nSales Amounts:");
        salesAmounts.forEach(System.out::println);

       
        double totalSales = northRegionSales.stream()
                .mapToDouble(SalesRecord::getAmount)
                .sum();

        System.out.println("\nTotal Sales Amount (North Region): " + totalSales);

        
        Map<String, List<SalesRecord>> salesByPerson = salesRecords.stream()
                .collect(Collectors.groupingBy(SalesRecord::getSalesPerson));

        System.out.println("\nSales Records Grouped by SalesPerson:");
        salesByPerson.forEach((salesPerson, records) -> {
            System.out.println("SalesPerson: " + salesPerson);
            records.forEach(System.out::println);
        });

        
        Map<String, Double> salesReport = salesRecords.stream()
                .collect(Collectors.groupingBy(SalesRecord::getSalesPerson,
                        Collectors.summingDouble(SalesRecord::getAmount)));

        System.out.println("\nSales Report (Total Sales by SalesPerson):");
        salesReport.forEach((salesPerson, total) -> 
            System.out.println("SalesPerson: " + salesPerson + ", Total Sales: " + total));
    }
}
