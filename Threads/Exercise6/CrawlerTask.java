import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

class CrawlerTask implements Runnable {
    final String url;
    final ConcurrentHashMap<String, String> crawledData;

    public CrawlerTask(String url, ConcurrentHashMap<String, String> crawledData) {
        this.url = url;
        this.crawledData = crawledData;
    }

    @Override
    public void run() {
        try {
            URL urlObj = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(urlObj.openStream()));
            StringBuilder content = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            crawledData.put(url, content.toString());
            System.out.println("Crawled: " + url);
        } catch (Exception e) {
            System.err.println("Failed to crawl: " + url + " - " + e.getMessage());
        }
    }
}
