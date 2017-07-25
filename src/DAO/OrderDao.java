package DAO;

import entities.Orders;

import java.util.Date;
import java.util.List;

/**
 * Created by prajapas on 7/13/2017.
 */
public interface OrderDao {
    public List<Orders> getAllOrders();
    public List<Orders> getOrders(Date from, Date to);
    public boolean placeOrder(Orders order);
}
