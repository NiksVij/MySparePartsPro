package entities;

/**
 * Created by prajapas on 7/13/2017.
 */
public class SpareParts {
    private String sparepart_ID;
    private String sparepartName;
    private String vehicle_model;
    private double price;
    private double tax;
    private int numbers;

    @Override
    public String toString() {
        return "SpareParts{" +
                "sparepart_ID='" + sparepart_ID + '\'' +
                ", sparepartName='" + sparepartName + '\'' +
                ", vehicle_model='" + vehicle_model + '\'' +
                ", price=" + price +
                ", tax=" + tax +
                ", numbers=" + numbers +
                "}\n";
    }

    public SpareParts(String sparepart_ID, String sparepartName, String vehicle_model, double price, double tax, int numbers) {
        this.sparepart_ID = sparepart_ID;
        this.sparepartName = sparepartName;
        this.vehicle_model = vehicle_model;
        this.price = price;
        this.tax = tax;
        this.numbers = numbers;
    }

    public String getSparepart_ID() {
        return sparepart_ID;
    }

    public void setSparepart_ID(String sparepart_ID) {
        this.sparepart_ID = sparepart_ID;
    }

    public String getSparepartName() {
        return sparepartName;
    }

    public void setSparepartName(String sparepartName) {
        this.sparepartName = sparepartName;
    }

    public String getVehicle_model() {
        return vehicle_model;
    }

    public void setVehicle_model(String vehicle_model) {
        this.vehicle_model = vehicle_model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }
}
