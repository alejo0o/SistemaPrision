/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;

import DP.PabellonDP;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author vivan
 */
public class PabellonMD {

    private DataSource getORCL() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/ORCL");
    }
    public Map<String, PabellonDP> consultar() {
        Map<String, PabellonDP> lista = new HashMap<>();
        try {
            DataSource ds = getORCL();
            Connection conexion = ds.getConnection();
            Statement sentencia = conexion.createStatement();
            ResultSet registros = sentencia.executeQuery("select * from pabellones");
            while (registros.next()) {
                PabellonDP dp = new PabellonDP();
                dp.setCodigo(registros.getString("PABCODIGO"));
                dp.setUbicacion(registros.getString("PABUBICACION"));
                dp.setSuperficie(registros.getDouble("PABSUPERFICIE"));
                dp.setNumeroceldas(registros.getInt("PABNUMEROCELDAS"));
                lista.put(registros.getString("PABCODIGO"),dp);
            }
            sentencia.close();
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(PabellonMD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
