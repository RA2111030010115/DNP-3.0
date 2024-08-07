import java.util.concurrent.*;

public class WebCrawler {
    static final int NUM_THREADS = 10;
    final ExecutorService executorService;
    final ConcurrentHashMap<String, String> crawledData;

    public WebCrawler() {
        this.executorService = Executors.newFixedThreadPool(NUM_THREADS);
        this.crawledData = new ConcurrentHashMap<>();
    }

    public void startCrawling(String[] urls) {
        for (String url : urls) {
            executorService.submit(new CrawlerTask(url, crawledData));
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    public void displayCrawledData() {
        for (String url : crawledData.keySet()) {
            System.out.println("URL: " + url + ", Data: " + crawledData.get(url));
        }
    }

    public static void main(String[] args) {
        WebCrawler webCrawler = new WebCrawler();
        String[] urls = {
            "http://example.com",
            "http://example.org",
            "http://example.net"
        };
        webCrawler.startCrawling(urls);
        webCrawler.displayCrawledData();
    }
}
