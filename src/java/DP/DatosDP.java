/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import MD.DatosMD;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author vivan
 */
@Named(value = "datosDP")
@RequestScoped
public class DatosDP {
    
    String turno;
    DatosMD md=new DatosMD();
    /**
     * Creates a new instance of DatosDP
     */
    public DatosDP() {
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    public Map<String, DatosDP> obtenerTurnos(){
        return md.consultar();
    }
    
}
