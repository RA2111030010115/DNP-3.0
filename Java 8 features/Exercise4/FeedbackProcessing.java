import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FeedbackProcessing {
    public static void main(String[] args) {
        List<Feedback> feedbackList = Arrays.asList(
            new Feedback(1, "Alice", 5, "Excellent service!"),
            new Feedback(2, "Bob", 2, "Not satisfied with the product."),
            new Feedback(3, "Charlie", 4, "Good experience."),
            new Feedback(4, "David", 1, "Very bad experience."),
            new Feedback(5, "Eve", 5, "Loved it!")
        );

        // Filter feedback based on a minimum rating
        List<Feedback> filteredFeedback = feedbackList.stream()
                .filter(fb -> fb.getRating() >= 4)
                .collect(Collectors.toList());

        System.out.println("Filtered Feedback:");
        filteredFeedback.forEach(System.out::println);

        // Map feedback to extract customer names and comments
        List<String> customerComments = filteredFeedback.stream()
                .map(fb -> fb.getCustomerName() + ": " + fb.getComments())
                .collect(Collectors.toList());

        System.out.println("\nCustomer Comments:");
        customerComments.forEach(System.out::println);

        // Reduce feedback to count the number of positive and negative feedbacks
        Map<String, Long> feedbackCount = feedbackList.stream()
                .collect(Collectors.groupingBy(
                        fb -> fb.getRating() >= 4 ? "Positive" : "Negative", 
                        Collectors.counting()
                ));

        System.out.println("\nFeedback Count:");
        feedbackCount.forEach((key, count) -> System.out.println(key + ": " + count));

        // Implement flexible processing
        processFeedback(feedbackList, fb -> fb.getRating() >= 4, fb -> fb.setComments(fb.getComments() + " (Processed)"));
        
        System.out.println("\nProcessed Feedback:");
        feedbackList.forEach(System.out::println);
    }

    public static void processFeedback(List<Feedback> feedbackList, FeedbackFilter filter, FeedbackProcessor processor) {
        feedbackList.stream()
                .filter(filter::filter)
                .forEach(processor::process);
    }
}
