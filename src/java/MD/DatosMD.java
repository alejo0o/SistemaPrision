/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;

import DP.DatosDP;
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
public class DatosMD {

    private DataSource getORCL() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/ORCL");
    }
    public Map<String, DatosDP> consultar() {
        Map<String, DatosDP> lista = new HashMap<>();
        try {
            DataSource ds = getORCL();
            Connection conexion = ds.getConnection();
            Statement sentencia = conexion.createStatement();
            ResultSet registros = sentencia.executeQuery("select * from TURNOS");
            while (registros.next()) {
                DatosDP dp = new DatosDP();
                dp.setTurno(registros.getString("TURNOS"));                        
                lista.put(registros.getString("TURNOS"),dp);
            }
            sentencia.close();
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(DatosMD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    
    
}
