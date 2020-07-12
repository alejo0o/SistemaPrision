/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import MD.GuardiasMD;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author vivan
 */
@Named(value = "guardiasDP")
@RequestScoped
public class GuardiasDP {
    private String identifiacion;//identifiación del guardia
    private String nombre;//nombre del guardia
    private String apellido;//appellido
    private String fechadenacimiento;//fecha de nacimiento del guardia
    private String genero;//genero del guardia
    private String rango;//nombramiento o titulo que posee el guardia
    private String lugardenacimiento;//lugar de nacimiento del guardia 
    private String estadocivil;//estado civil del guardia
    private String nacionalidad;//nacionalidad del guardia
    GuardiasMD md=new GuardiasMD();//variable md del tipo Guardias MD

    /**
     * Creates a new instance of GuardiasDP
     */
    public GuardiasDP() {
    }

    public String getIdentifiacion() {
        return identifiacion;
    }

    public void setIdentifiacion(String identifiacion) {
        this.identifiacion = identifiacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechadenacimiento() {
        return fechadenacimiento;
    }

    public void setFechadenacimiento(String fechadenacimiento) {
        this.fechadenacimiento = fechadenacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getLugardenacimiento() {
        return lugardenacimiento;
    }

    public void setLugardenacimiento(String lugardenacimiento) {
        this.lugardenacimiento = lugardenacimiento;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public GuardiasMD getMd() {
        return md;
    }

    public void setMd(GuardiasMD md) {
        this.md = md;
    }
    public Map<String, GuardiasDP> consultar(){
        return md.consultar();
    }
    
}
