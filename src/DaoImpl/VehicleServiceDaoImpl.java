package DaoImpl;

import entities.VehicleService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.http.HttpSession;
import java.io.PrintStream;
import java.util.Date;
import java.util.List;

/**
 * Created by vijayn on 7/28/2017.
 */
public class VehicleServiceDaoImpl implements DAO.VehicleServiceDao {
    private static SessionFactory factory;
    static Session session;
    static PrintStream ps =System.out;
    static {


    }
    public VehicleServiceDaoImpl(){
        ps.println("In VehicleServiceDaoImpl ");
    }

    @Override
    public boolean addVService(String reg_no, String owner_name, String make_model, String odo_reading, String serv_no, String paid, Date purchase_date) {

        return met(reg_no,owner_name,make_model,odo_reading,serv_no,paid,purchase_date);

    }
    static boolean met(String reg_no, String owner_name, String make_model, String odo_reading, String serv_no, String paid, Date purchase_date)
        {
            try{
                factory = new Configuration().configure().buildSessionFactory();
                ps.println("factory created");

            }catch (Throwable ex) {
                System.err.println("Failed to create sessionFactory object." + ex);
                throw new ExceptionInInitializerError(ex);
            }
            session = factory.openSession();
            ps.println(factory+","+session);
        ps.println(reg_no+","+owner_name+","+make_model+","+odo_reading+","+serv_no+","+paid+","+purchase_date);
        ps.println("In addVService ");
        boolean re=false;
        Transaction tx = null;
        Integer vehServiceID=null;
        ps.println("After factory.openSession() ");

        try {
            tx = session.beginTransaction();
            VehicleService vehicleService = new VehicleService(reg_no,owner_name,make_model,odo_reading,serv_no,paid,purchase_date);
            ps.println("After vehicleService creation ");
            /*vehServiceID = (Integer)*/ session.save(vehicleService);
            tx.commit();
            re= true;
        }
        catch (HibernateException he){
            if(he!=null)
                tx.rollback();
            he.printStackTrace();
        }
        finally {
            session.close();
        }

        System.out.println("MyLog: vehServiceID "+vehServiceID);
        return re;
    }
    @Override
    public List<VehicleService> getAllVehicles() {

        return null;
    }
}
