package javaapplication18;

import java.sql.Connection;
import java.sql.DriverManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class JavaApplication18 {
    public Connection conectar(){
         Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/tienda?user=root&&password=mysqladmin";
            con = (Connection) DriverManager.getConnection(url);
            if (con != null) {
                System.out.println("te has conectado");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
public static void main(String[] args) {
    JavaApplication18 jl = new JavaApplication18();
    
      try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(JavaApplication18.class.getResource("./reporte_principal.jasper"));
            JasperPrint jp = JasperFillManager.fillReport(jr, null,jl.conectar());
            JasperViewer jv = new JasperViewer(jp);
            jv.show();
        } catch (JRException e) {
            System.err.print(e);
        }
    }
}
