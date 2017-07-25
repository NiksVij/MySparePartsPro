package entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by prajapas on 7/13/2017.
 */
public class Orders {
    String orderedBy;
    String orderId;
    String vehicleModel;
    String sparePartId;
    String sparePartName;
    String operation;
    int numbers;
    double price;
    double tax;
    Date date;
    public Orders(String orderedBy, String orderId, String vehicleModel, String sparePartId, String sparePartName, String operation, int numbers, double price, double tax, Date date) {
        this.orderedBy = orderedBy;
        this.orderId = orderId;
        this.vehicleModel = vehicleModel;
        this.sparePartId = sparePartId;
        this.sparePartName = sparePartName;
        this.operation = operation;
        this.numbers = numbers;
        this.price = price;
        this.tax = tax;
        this.date = date;
    }
    public String toStringHTMLTable(){
        return "<td>"+orderedBy + "</td>" +"<td>"+
                orderId + "</td>" +"<td>"+
                vehicleModel + "</td>" +"<td>"+
                sparePartId + "</td>" +"<td>"+
                sparePartName + "</td>" +"<td>"+
                operation + "</td>" +"<td>"+
                numbers +"</td>" +"<td>"+
                price +"</td>" +"<td>"+
                tax +"</td>" +"<td>"+
                date+"</td>" ;
    }
    @Override
    public String toString() {
        /*return "Orders{" +
                "orderedBy='" + orderedBy + '\'' +
                ", orderId='" + orderId + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", sparePartId='" + sparePartId + '\'' +
                ", sparePartName='" + sparePartName + '\'' +
                ", operation='" + operation + '\'' +
                ", numbers=" + numbers +
                ", price=" + price +
                ", tax=" + tax +
                ", date=" + date +
                "}\n";*/

        return
                orderedBy + "|\t" +
                orderId + "|\t"+
                vehicleModel + "|\t" +
                sparePartId + "|\t" +
                sparePartName + "|\t" +
                operation + "|\t" +
                numbers +"|\t"+
                price +"|\t"+
                tax +"|\t"+
                date ;
    }

    public String getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(String orderedBy) {
        this.orderedBy = orderedBy;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getSparePartId() {
        return sparePartId;
    }

    public void setSparePartId(String sparePartId) {
        this.sparePartId = sparePartId;
    }

    public String getSparePartName() {
        return sparePartName;
    }

    public void setSparePartName(String sparePartName) {
        this.sparePartName = sparePartName;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
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

    public String getDate() {

        DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        String s  = df.format(date);
        return s;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
