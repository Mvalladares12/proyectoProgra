/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controlador;

import facade.ServiciosFacadeLocal;
import facade.ServiciosService;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Servicios;
import org.primefaces.model.file.UploadedFile;
//import org.primefaces.util.IOUtils;
import org.apache.poi.util.IOUtils;
import org.primefaces.PrimeFaces;

/**
 *
 * @author mario_5ymtv0r
 */
@Named(value = "servicioBean")
@SessionScoped
public class ServicioBean implements Serializable {

    @EJB
    private ServiciosFacadeLocal ServiciosF; 
    
    private List<Servicios> ListServ;
    private Servicios servicios;
    private UploadedFile UF;

    public List<Servicios> getListServ() {
        this.ListServ=ServiciosF.findAll();
        return ListServ;
    }

    public void setListServ(List<Servicios> ListServ) {
        this.ListServ = ListServ;
    }

    public UploadedFile getUF() {
        return UF;
    }

    public void setUF(UploadedFile UF) {
        this.UF = UF;
    }

    public Servicios getServicios() {
        return servicios;
    }

    public void setServicios(Servicios servicios) {    
        this.servicios = servicios;
    }

    public ServicioBean() {
    }
    
    @PostConstruct
    public void init(){
        this.servicios= new Servicios();
    }
    
    public void registrarServicio() {
        String ubi="D:\\Materias\\Progra IV\\ProyectoProgra\\web\\Resources\\Img";
        try{
            servicios.setImagen(UF.getFileName());
            ServiciosF.create(servicios);
            writeImage(IOUtils.toByteArray(UF.getInputStream()), ubi, UF.getFileName());
        }catch(IOException x){
            System.out.println("Error, "+x.getMessage());
        }
    }

    private void writeImage(byte[] toByteArray, String ubi, String fileName) {
        try{
            Path path=Paths.get(ubi, fileName);
            Files.write(path, toByteArray);
        }catch(IOException x){
            x.getMessage();
        }
    }   
    
    public void registroServicio(){
        String msj;
        try{
            ServiciosF.create(servicios);
            msj="Datos almacenados con exito";
        }catch(Exception x){
            msj="Error"+x.getMessage();
        }
        FacesMessage message=new FacesMessage(msj);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void eliminarServicio(Servicios servicios){
        String msj;
        try{
            ServiciosF.remove(servicios);
            msj="Datos eliminados con exito";
        }catch(Exception x){
            msj="Error"+x.getMessage();
        }
        FacesMessage message=new FacesMessage(msj);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void editServ(){
        try{
            ServiciosF.edit(servicios);
        }catch(Exception x){
            throw x;
        }
        PrimeFaces.current().executeScript("PF('editF').hide()");
        PrimeFaces.current().ajax().update("form:dtUser");
    }
}
