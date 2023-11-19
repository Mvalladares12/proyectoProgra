/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import facade.ServiciosFacadeLocal;
import facade.UsuarioFacade;
import facade.UsuarioFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.*;
import modelo.Servicios;
import modelo.Usuario;
import org.primefaces.PrimeFaces;

/**
 *
 * @author mario_5ymtv0r
 */

@Named("registrar")
@RequestScoped
public class Registrar implements Serializable{
    @Inject
    private ServiciosFacadeLocal SFL;
    private Servicios servicios;
    private UsuarioFacadeLocal UFL;
    private Usuario usuario;
    private UsuarioFacade usuarioF;
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @PostConstruct
    public void init(){
        usuario=new Usuario();
        servicios=new Servicios();
    }
    
    //este metodo es para cuando se registra un cliente se le otorga el rol de usuario automaticamente
    public void registrarUsuario(){
        String msj;
        try{
            usuario.setRol("Usuario");
            UFL.create(usuario);
            msj="Datos almacenados con exito";
        }catch(Exception x){
            msj="Error"+x.getMessage();
        }
        FacesMessage mensaje=new FacesMessage(msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    //Este metodo es para poder elegir el rol del usuario
    public void registroUser(){
        String msj;
        try{
            UFL.create(usuario);
            msj="Datos almacenados con exito";
        }catch(Exception x){
            msj="Error"+x.getMessage();
        }
        FacesMessage message=new FacesMessage(msj);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void editUser(){
        try{
            if(this.usuario.getIdUsuario()!=null){
               UFL.edit(usuario);
            }    
        }catch(Exception x){
            throw x;
        }
        PrimeFaces.current().executeScript("PF('editF').hide()");
        PrimeFaces.current().ajax().update("form:dtUser");
    }
    
}
