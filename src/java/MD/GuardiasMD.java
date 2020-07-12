/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;

import DP.GuardiasDP;
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
public class GuardiasMD {

    private DataSource getORCL() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/ORCL");
    }
    public Map<String, GuardiasDP> consultar() {
        Map<String, GuardiasDP> lista = new HashMap<>();
        try {
            DataSource ds = getORCL();
            Connection conexion = ds.getConnection();
            Statement sentencia = conexion.createStatement();
            ResultSet registros = sentencia.executeQuery("select * from guardias");
            while (registros.next()) {
                GuardiasDP dp = new GuardiasDP();
                dp.setIdentifiacion(registros.getString("GUAIDENTIFICACION"));
                dp.setNombre(registros.getString("GUANOMBRE"));
                dp.setApellido(registros.getString("GUAAPELLIDO"));
                dp.setFechadenacimiento(registros.getString("GUAFECHANACIEMENTO"));
                dp.setGenero(registros.getString("GUAGENERO"));
                dp.setRango(registros.getString("GUARANGO"));
                dp.setLugardenacimiento(registros.getString("GUALUGARNACIMIENTO"));
                dp.setEstadocivil(registros.getString("GUAESTADOCIVIL"));
                dp.setNacionalidad(registros.getString("GUANACIONALIDAD")); 
                lista.put(registros.getString("GUAIDENTIFICACION"),dp);
            }
            sentencia.close();
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(GuardiasMD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }    
}
