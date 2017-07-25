import DaoImpl.OperatorDaoImpl;
import DaoImpl.OrderDaoImpl;
import entities.Operator;
import entities.Orders;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by vijayn on 7/23/2017.
 */
@WebServlet(name = "HomeServlet")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        met(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        met(request,response);
    }
    void met(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session!=null){System.out.println(session);}else {System.out.println("null session in home serv");}

        PrintWriter pw = response.getWriter();

        String username =request.getParameter("ao_uname");
        String password = request.getParameter("ao_pass");
        OperatorDaoImpl operator = new OperatorDaoImpl();

        if(username!=null&&password!=null){
            boolean result = operator.addOpertor(new Operator(username, password, true));
            RequestDispatcher rd = request.getRequestDispatcher("AddOperator.html");
            rd.include(request,response);
            if(result){
                pw.print("<br>Operator generated successfully");
            }
            else {
                pw.print("<br>Operation FAILED!");
            }
            return;
        }

        String bo_un = request.getParameter("bo_un");
        if(bo_un!=null){
            RequestDispatcher rd = request.getRequestDispatcher("BlockOperator.html");
            rd.include(request,response);
            boolean result = operator.blockOperator(bo_un);

            if(result){
                pw.print("<br>Operator generated successfully");
            }
            else {
                pw.print("<br>Operation FAILED!");
            }
            return;
        }

        /*String po_order_id = request.getParameter("po_order_id");
        String po_vehicle_model = request.getParameter("po_vehicle_model");
        String po_sparepart_id = request.getParameter("po_sparepart_id");
        String po_sparepart_name = request.getParameter("po_sparepart_name");
        String po_operation = request.getParameter("po_operation");
        String po_unit = request.getParameter("po_unit");
        String po_price = request.getParameter("po_price");
        String po_tax = request.getParameter("po_tax");*/
        RequestDispatcher rd = request.getRequestDispatcher("Home_Admin.html");
        rd.include(request,response);
        OrderDaoImpl od = new OrderDaoImpl();
        System.out.print("enter dates in dd/mm/yyyy");
        String date1 = "01/01/0001";
        String date2 = "31/12/9999";
//        pw.print("<br><br><br<br><br>");
        try {
            Date date_1 = new SimpleDateFormat("dd/MM/yyyy").parse(date1);
            Date date_2 = new SimpleDateFormat("dd/MM/yyyy").parse(date2);
            List<Orders> ls = od.getOrders(date_1, date_2);
            String style="<style>\n" +
                    "table {\n" +
                    "    font-family: arial, sans-serif;\n" +
                    "    border-collapse: collapse;\n" +
                    "    width: 100%;\n" +
                    "}\n" +
                    "\n" +
                    "td, th {\n" +
                    "    border: 1px solid #dddddd;\n" +
                    "    text-align: left;\n" +
                    "    padding: 8px;\n" +
                    "}\n" +
                    "\n" +
                    "tr:nth-child(even) {\n" +
                    "    background-color: #dddddd;\n" +
                    "}\n" +
                    "</style>";
            pw.print(style);
            String cmmnds ="<table align='center'> <tr>";
            pw.print(cmmnds);//</tr></table>";
            String str= "<th> orderedBy&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>"+
                   "<th> orderId&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>" +
                    "<th> vehicleModel&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>" +
                    "<th>sparePartId&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </th>" +
                    "<th>sparePartName&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </th>" +
                    "<th>operation&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </th>" +
                    "<th>numbers&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </th>" +
                    "<th>price&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </th>" +
                    "<th>tax&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </th>" +
                    "<th>date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </th> </tr>" ;
            pw.print(str);
            for(Orders orders:ls){
                pw.print("<tr>");
                pw.print(orders.toStringHTMLTable()+"<br><br>");
                pw.print("</tr>");
            }
            pw.print("</table>");
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
