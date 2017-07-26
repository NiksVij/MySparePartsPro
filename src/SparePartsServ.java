import DaoImpl.SparePartsDaoImpl;
import entities.SpareParts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by vijayn on 7/24/2017.
 */
@WebServlet(name = "SparePartsServ")
public class SparePartsServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        met(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        met(request,response);
    }
    private void met(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String spareOp = request.getParameter("spare");
        String po_sparepart_id = request.getParameter("po_sparepart_id");

        if(spareOp.equals("Add"))
        {
            String po_vehicle_model = request.getParameter("po_vehicle_model");
            String po_sparepart_name = request.getParameter("po_sparepart_name");
            int po_unit = Integer.parseInt(request.getParameter("po_unit"));
            double po_price = Double.parseDouble(request.getParameter("po_price"));
            double po_tax = Double.parseDouble(request.getParameter("po_tax"));
        SpareParts spareParts = new SpareParts(po_sparepart_id, po_sparepart_name, po_vehicle_model, po_price
                , po_tax, po_unit);
        SparePartsDaoImpl sp = new SparePartsDaoImpl();
        boolean result =sp.addSparePart(spareParts);
        request.getRequestDispatcher("AddSpareParts.jsp").include(request,response);
        if(result)
            response.getWriter().println("Spare Part Added Succesfully");
        else
            response.getWriter().println("ERROR in Spare Part Adding");
        }
        else{
            //UPDATE spareparts SET units = units -1 WHERE (sparepartid='tyre786' AND units>0);
            /*SpareParts spareParts = new SpareParts(po_sparepart_id, po_sparepart_name, po_vehicle_model, po_price
                    , po_tax, po_unit);
            SparePartsDaoImpl sp = new SparePartsDaoImpl();*/

            boolean result =(new SparePartsDaoImpl()).removeSpareParts(po_sparepart_id);
            if(result){
                response.getWriter().println("Spare Part removed Succesfully");
                HttpSession session = request.getSession(false);
                session.setAttribute("operation","Action Successful");
                response.getWriter().println("Spare Part Removed");
            }

            else{
                response.getWriter().println("ERROR in Removing spareparts");
                HttpSession session = request.getSession(false);
                session.setAttribute("operation","FAILED ACTION");
                response.getWriter().println("ERROR In Spare Part Removing");
            }
            request.getRequestDispatcher("RemoveSpareParts.jsp").include(request,response);
        }
    }
}
