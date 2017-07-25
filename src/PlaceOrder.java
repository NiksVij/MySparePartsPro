import DaoImpl.OrderDaoImpl;
import entities.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Created by vijayn on 7/24/2017.
 */
@WebServlet(name = "PlaceOrder")
public class PlaceOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        met(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        met(request,response);
    }
    void met(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String po_order_id = request.getParameter("po_order_id");
        String po_vehicle_model = request.getParameter("po_vehicle_model");
        String po_sparepart_id = request.getParameter("po_sparepart_id");
        String po_sparepart_name = request.getParameter("po_sparepart_name");
        String po_operation = request.getParameter("po_operation");
        int po_unit = Integer.parseInt(request.getParameter("po_unit"));
        double po_price = Double.parseDouble(request.getParameter("po_price"));
        double po_tax = Double.parseDouble(request.getParameter("po_tax"));

        HttpSession session = request.getSession(false);
        OrderDaoImpl od = new OrderDaoImpl();
        Date date = new Date(System.currentTimeMillis());
        if(session==null){
            System.out.println("\nnull session");
            return;
        }
        String str = (String) session.getAttribute("uname");
        System.out.println(str);
        boolean result =od.placeOrder(new Orders(((String) session.getAttribute("username")),po_order_id,po_vehicle_model,po_sparepart_id
                ,po_sparepart_name,po_operation,po_unit,po_price,po_tax,date));
            if(result){
                response.getWriter().print("Order Placed successfully");
            }else {
                response.getWriter().print("Order UNSUCCESSFUL!");
            }
    }
}
