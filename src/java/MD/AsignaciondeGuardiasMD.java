/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD;

import DP.AsignaciondeGuardiasDP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
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
public class AsignaciondeGuardiasMD {

    private DataSource getORCL() throws NamingException  {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/ORCL");
    }
     public void crear(AsignaciondeGuardiasDP dp) {
        try {
            String codigo = dp.getCodigo();
            String guardia = dp.getGuaidentifiacion(), pabellon = dp.getPabcodigo();
            String turno = dp.getTurno();
            String observaciones=dp.getObservaciones();
            Date periodoinicio = dp.getPerdiodoinicio() , periodofin=dp.getPerdiodofin();
            SimpleDateFormat format = new SimpleDateFormat ("dd/MMM/yyyy");
            String periodoinicio2=format.format(periodoinicio);
            String periodofin2=format.format(periodofin);
            DataSource ds = getORCL();
            Connection conexion = ds.getConnection();
            String sql = "insert into ASIGNACION_DE_GUARDIAS (ASICODIGOG, GUAIDENTIFICACION, PABCODIGO, ASITURNO, ASIPERIODOINICIO, ASIPERIODOFIN, ASIOBSERVACIONES) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.setString(2, guardia);
            ps.setString(3, pabellon);
            ps.setString(4, turno);
            ps.setString(5, periodoinicio2);
            ps.setString(6, periodofin2);
            ps.setString(7, observaciones);
            ps.execute();
            ps.close();
            conexion.close();
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(AsignaciondeGuardiasMD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modificar(AsignaciondeGuardiasDP dp){
        try {
            String codigo = dp.getCodigo();
            String guardia = dp.getGuaidentifiacion(), pabellon = dp.getPabcodigo();
            String turno = dp.getTurno();
            String observaciones=dp.getObservaciones();
            Date periodoinicio = dp.getPerdiodoinicio() , periodofin=dp.getPerdiodofin();
            SimpleDateFormat format = new SimpleDateFormat ("dd/MMM/yyyy");
            String periodoinicio2=format.format(periodoinicio);
            String periodofin2=format.format(periodofin);
            DataSource ds = getORCL();
            Connection conexion = ds.getConnection();
            String sql="UPDATE ASIGNACION_DE_GUARDIAS set GUAIDENTIFICACION=?,PABCODIGO=?,ASITURNO=?,ASIPERIODOINICIO=?,ASIPERIODOFIN=?,ASIOBSERVACIONES=? WHERE ASICODIGOG"
                    + "='"+codigo+"'";//Sentencia SQL para ejecutar sobre la base
            PreparedStatement ps=conexion.prepareStatement(sql);//variable usada para obtener informacion del registro de la base
            ps.setString(1,guardia);
            ps.setString(2,pabellon);
            ps.setString(3,turno);
            ps.setString(4,periodoinicio2);
            ps.setString(5,periodofin2);
            ps.setString(6,observaciones);     
            ps.execute();
            conexion.close();      
        } catch (NamingException ex) {
            Logger.getLogger(AsignaciondeGuardiasMD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AsignaciondeGuardiasMD.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
    public void eliminar(AsignaciondeGuardiasDP dp) {
        try {
            DataSource ds = getORCL();
            Connection conexion = ds.getConnection();
            String codigo = dp.getCodigo();
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate("delete from ASIGNACION_DE_GUARDIAS where asicodigog='" + codigo + "'");
            conexion.close();
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(AsignaciondeGuardiasMD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(AsignaciondeGuardiasMD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Map<String, AsignaciondeGuardiasDP> consultar() {
        Map<String, AsignaciondeGuardiasDP> lista = new HashMap<>();
        try {
            DataSource ds = getORCL();
            Connection conexion = ds.getConnection();
            Statement sentencia = conexion.createStatement();
            ResultSet registros = sentencia.executeQuery("select * from ASIGNACION_DE_GUARDIAS");
            while (registros.next()) {
                AsignaciondeGuardiasDP dp = new AsignaciondeGuardiasDP();
                dp.setCodigo(registros.getString("ASICODIGOG"));
                dp.setGuaidentifiacion(registros.getString("GUAIDENTIFICACION"));
                dp.setPabcodigo(registros.getString("PABCODIGO"));
                dp.setTurno(registros.getString("ASITURNO"));
                dp.setPerdiodoinicio(registros.getDate("ASIPERIODOINICIO"));
                dp.setPerdiodofin(registros.getDate("ASIPERIODOFIN"));
                dp.setObservaciones(registros.getString("ASIOBSERVACIONES"));                 
                lista.put(registros.getString("ASICODIGOG"),dp);
            }
            sentencia.close();
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(AsignaciondeGuardiasDP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }    
    public Map<String, AsignaciondeGuardiasDP> consultarParametro(String param, String busca) {
        boolean x = false;
        Map<String, AsignaciondeGuardiasDP> lista = new HashMap<>();
        try {
            DataSource ds = getORCL();
            Connection conexion = ds.getConnection();
            Statement consulta = conexion.createStatement();
            ResultSet registros = consulta.executeQuery("select * from ASIGNACION_DE_GUARDIAS where " + param + " = '" + busca + "'");
            while (registros.next()) {
                AsignaciondeGuardiasDP dp = new AsignaciondeGuardiasDP();
                dp.setCodigo(registros.getString("ASICODIGOG"));
                dp.setGuaidentifiacion(registros.getString("GUAIDENTIFICACION"));
                dp.setPabcodigo(registros.getString("PABCODIGO"));
                dp.setTurno(registros.getString("ASITURNO"));
                dp.setPerdiodoinicio(registros.getDate("ASIPERIODOINICIO"));
                dp.setPerdiodofin(registros.getDate("ASIPERIODOFIN"));
                dp.setObservaciones(registros.getString("ASIOBSERVACIONES"));     
                lista.put(registros.getString(1), dp);
                x = true;
            }
            consulta.close();
            conexion.close();
        } catch (SQLException e) {
        } catch (NamingException ex) {
            Logger.getLogger(AsignaciondeGuardiasMD.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (x) {
            return lista;
        } else {
            return null;
        }
    }
    public LinkedList cargarCampos() {
        LinkedList lista = new LinkedList();
        try {
            DataSource ds = getORCL();
            Connection conexion = ds.getConnection();
            Statement sentencia = conexion.createStatement();
            ResultSet result = sentencia.executeQuery("select column_name from all_tab_columns where table_name ='ASIGNACION_DE_GUARDIAS'");
            while (result.next()) {
                String campo = result.getString(1);
                lista.add(campo);
            }
            sentencia.close();
        } catch (SQLException ex) {
        } catch (NamingException ex) {
            Logger.getLogger(AsignaciondeGuardiasMD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    public AsignaciondeGuardiasDP consultar(AsignaciondeGuardiasDP dp1){
        boolean x = false;
        AsignaciondeGuardiasDP dp=new AsignaciondeGuardiasDP();//variable de tipo Guardias DP 
        try{
            DataSource ds = getORCL();
            Connection conexion = ds.getConnection();//variable usada para establecer la coneccion con la base de datos
            Statement sentencia= conexion.createStatement();//variable usada para obtener informacion del registro de la base   
            ResultSet registros=sentencia.executeQuery("SELECT * FROM ASIGNACION_DE_GUARDIAS WHERE ASICODIGOG='"+dp1.getCodigo()+"'");//variable usada para obtener informacion del registro de la base    
            while(registros.next()){
                dp.setCodigo(registros.getString("ASICODIGOG"));
                dp.setGuaidentifiacion(registros.getString("GUAIDENTIFICACION"));
                dp.setPabcodigo(registros.getString("PABCODIGO"));
                dp.setTurno(registros.getString("ASITURNO"));
                dp.setPerdiodoinicio(registros.getDate("ASIPERIODOINICIO"));
                dp.setPerdiodofin(registros.getDate("ASIPERIODOFIN"));
                dp.setObservaciones(registros.getString("ASIOBSERVACIONES"));     
                x = true;
            }      
            conexion.close();
            sentencia.close();    
        }catch (SQLException ex) {
            Logger.getLogger(AsignaciondeGuardiasMD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(AsignaciondeGuardiasMD.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (x) {
            return dp;
        } else {
            return null;
        }     
    }
    
}
