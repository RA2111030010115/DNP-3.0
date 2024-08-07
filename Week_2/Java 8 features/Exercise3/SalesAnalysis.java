import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SalesAnalysis {

    public static void main(String[] args) {
        
        List<SalesRecord> records = new ArrayList<>();
        records.add(new SalesRecord("2023-01-01", "East", "Electronics", 1500.0, 5));
        records.add(new SalesRecord("2023-01-02", "West", "Books", 800.0, 3));
        records.add(new SalesRecord("2023-01-03", "North", "Electronics", 1200.0, 4));
        records.add(new SalesRecord("2023-01-04", "South", "Books", 1000.0, 2));

        
        String targetCategory = "Electronics";
        List<SalesRecord> filteredAndSorted = records.stream()
                .filter(record -> record.getProductCategory().equals(targetCategory))
                .sorted(Comparator.comparing(SalesRecord::getDate))
                .collect(Collectors.toList());

        
        System.out.println("Filtered and Sorted Records for Product Category: " + targetCategory);
        filteredAndSorted.forEach(System.out::println);

        
        String targetRegion = "East";
        double averageSales = records.stream()
                .filter(record -> record.getRegion().equals(targetRegion))
                .mapToDouble(SalesRecord::getAmount)
                .average()
                .orElse(0.0);

        
        System.out.println("\nAverage Sales Amount for Region " + targetRegion + ": " + averageSales);

        
        Optional<SalesRecord> topSalesRecord = records.stream()
                .max(Comparator.comparing(SalesRecord::getAmount));

        
        topSalesRecord.ifPresent(record -> System.out.println("\nTop Sales Record: " + record));

        
        long startTimeSequential = System.nanoTime();
        List<SalesRecord> filteredAndSortedSequential = records.stream()
                .filter(record -> record.getProductCategory().equals(targetCategory))
                .sorted(Comparator.comparing(SalesRecord::getDate))
                .collect(Collectors.toList());
        long endTimeSequential = System.nanoTime();
        long timeSequential = TimeUnit.NANOSECONDS.toMillis(endTimeSequential - startTimeSequential);

        long startTimeParallel = System.nanoTime();
        List<SalesRecord> filteredAndSortedParallel = records.parallelStream()
                .filter(record -> record.getProductCategory().equals(targetCategory))
                .sorted(Comparator.comparing(SalesRecord::getDate))
                .collect(Collectors.toList());
        long endTimeParallel = System.nanoTime();
        long timeParallel = TimeUnit.NANOSECONDS.toMillis(endTimeParallel - startTimeParallel);

        
        System.out.println("\nTime taken for Sequential Stream: " + timeSequential + " ms");
        System.out.println("Time taken for Parallel Stream: " + timeParallel + " ms");

        
        System.out.println("\nFiltered and Sorted Records (Parallel):");
        filteredAndSortedParallel.forEach(System.out::println);
    }
}