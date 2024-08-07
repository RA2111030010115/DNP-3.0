import java.time.LocalDate;

public class SalesRecord {
    int recordId;
    String salesPerson;
    String region;
    double amount;
    LocalDate date;

    public SalesRecord(int recordId, String salesPerson, String region, double amount, LocalDate date) {
        this.recordId = recordId;
        this.salesPerson = salesPerson;
        this.region = region;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return "SalesRecord{" +
                "recordId=" + recordId +
                ", salesPerson='" + salesPerson + '\'' +
                ", region='" + region + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }

    public int getRecordId() {
        return recordId;
    }

    public String getSalesPerson() {
        return salesPerson;
    }

    public String getRegion() {
        return region;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}

