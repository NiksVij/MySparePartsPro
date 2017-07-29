package entities;

import java.util.Date;

/**
 * Created by vijayn on 7/28/2017.
 */
public class VehicleService {
    private String reg_no,owner_name,make_model,odo_reading,serv_no,paid;
    Date purchase_date;
    VehicleService(){}
    public VehicleService(String reg_no, String owner_name, String make_model, String odo_reading, String serv_no, String paid, Date purchase_date) {
        this.reg_no = reg_no;
        this.owner_name = owner_name;
        this.make_model = make_model;
        this.odo_reading = odo_reading;
        this.serv_no = serv_no;
        this.paid = paid;
        this.purchase_date = purchase_date;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getMake_model() {
        return make_model;
    }

    public void setMake_model(String make_model) {
        this.make_model = make_model;
    }

    public String getOdo_reading() {
        return odo_reading;
    }

    public void setOdo_reading(String odo_reading) {
        this.odo_reading = odo_reading;
    }

    public String getServ_no() {
        return serv_no;
    }

    public void setServ_no(String serv_no) {
        this.serv_no = serv_no;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }
}
