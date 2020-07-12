/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import MD.AsignaciondeGuardiasMD;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author vivan
 */
@Named(value = "asignaciondeGuardiasDP")
@RequestScoped
public class AsignaciondeGuardiasDP {

    String codigo = "";
    String guaidentifiacion = "";
    String pabcodigo = "";
    String turno = "";
    Date perdiodoinicio = new Date();
    Date perdiodofin = new Date();
    String observaciones = "";
    AsignaciondeGuardiasMD md = new AsignaciondeGuardiasMD();
    AsignaciondeGuardiasDP vardp;
    List<AsignaciondeGuardiasDP> listaconsulta= new ArrayList();

    /**
     * Creates a new instance of AsignaciondeGuardiasDP
     */
    
    @PostConstruct
    public void init(){
        for (Entry<String, AsignaciondeGuardiasDP> e : md.consultar().entrySet()) {
            AsignaciondeGuardiasDP dp1=new AsignaciondeGuardiasDP();
            dp1=e.getValue();
            listaconsulta.add(dp1);
        }   
        
    }
    
    
    public AsignaciondeGuardiasDP() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getGuaidentifiacion() {
        return guaidentifiacion;
    }

    public void setGuaidentifiacion(String guaidentifiacion) {
        this.guaidentifiacion = guaidentifiacion;
    }

    public String getPabcodigo() {
        return pabcodigo;
    }

    public void setPabcodigo(String pabcodigo) {
        this.pabcodigo = pabcodigo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Date getPerdiodoinicio() {
        return perdiodoinicio;
    }

    public void setPerdiodoinicio(Date perdiodoinicio) {
        this.perdiodoinicio = perdiodoinicio;
    }

    public Date getPerdiodofin() {
        return perdiodofin;
    }

    public void setPerdiodofin(Date perdiodofin) {
        this.perdiodofin = perdiodofin;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public AsignaciondeGuardiasDP getVardp() {
        return vardp;
    }

    public void setVardp(AsignaciondeGuardiasDP vardp) {
        this.vardp = vardp;
    }   

    public List<AsignaciondeGuardiasDP> getListaconsulta() {
        return listaconsulta;
    }

    public void setListaconsulta(List<AsignaciondeGuardiasDP> listaconsulta) {
        this.listaconsulta = listaconsulta;
    }

    
    

    
    
    

    public void crear() {
        md.crear(this);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado exitoso", ""));
    }

    public void modificar() {
        md.modificar(this);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificación exitosa", ""));
    }

    public void eliminar() {
        md.eliminar(this);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminación exitosa", ""));
    }
  

    public LinkedList cargarCampos() {
        return md.cargarCampos();
    }

    public void consultar1() {
        vardp = new AsignaciondeGuardiasDP();
        vardp.setCodigo(this.codigo);
        vardp = md.consultar(vardp);
    }
    public Map<String, AsignaciondeGuardiasDP> consultar3(){
        return md.consultar();
    }
    
}
