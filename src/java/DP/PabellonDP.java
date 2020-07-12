/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import MD.PabellonMD;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author vivan
 */
@Named(value = "pabellonDP")
@RequestScoped
public class PabellonDP {
    private String codigo; //codigo del pabellón
    private String ubicacion;//ubicación del pabellón
    private double superficie;//superficie del pabellón
    private int numeroceldas;//cantidad de celdas que contiene el pabellón
    PabellonMD pabellonMD=new PabellonMD();

    /**
     * Creates a new instance of PabellonDP
     */
    public PabellonDP() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public int getNumeroceldas() {
        return numeroceldas;
    }

    public void setNumeroceldas(int numeroceldas) {
        this.numeroceldas = numeroceldas;
    }
    public Map<String, PabellonDP> consultar(){
        return pabellonMD.consultar();
    }
    
}
