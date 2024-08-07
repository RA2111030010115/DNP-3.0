import java.io.Serializable;

public class SalesRecord implements Serializable {

    String date;
    String region;
    String productCategory;
    double amount;
    int quantity;

    public SalesRecord(String date, String region, String productCategory, double amount, int quantity) {
        this.date = date;
        this.region = region;
        this.productCategory = productCategory;
        this.amount = amount;
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public String getRegion() {
        return region;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public double getAmount() {
        return amount;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "SalesRecord{" +
                "date='" + date + '\'' +
                ", region='" + region + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", amount=" + amount +
                ", quantity=" + quantity +
                '}';
    }
}