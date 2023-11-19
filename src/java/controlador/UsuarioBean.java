 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;



import facade.UsuarioFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.*;
import modelo.Usuario;
import facade.UsuarioService;
import java.util.List;
import javax.ejb.EJB;
import modelo.Servicios;
import org.primefaces.PrimeFaces;

/**
 *
 * @author mario_5ymtv0r
 */

@Named("usuarioBean")
@RequestScoped
public class UsuarioBean implements Serializable{
    @EJB
    private UsuarioService usuarioService;
    private UsuarioFacadeLocal UFL;
    private Usuario usuario;
    List<Usuario> usuarios;
    
    public UsuarioBean(){
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
        
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @PostConstruct
    public void init(){
        this.usuario=new Usuario();
        this.usuarios=usuarioService.listarUsuario();
    }
    
    public String iniciarSesion() throws Exception{      
        String redireccion=null;
        FacesContext context=FacesContext.getCurrentInstance();
        try{
            usuario=usuarioService.encontrarUsuario(usuario);
            if(usuario!=null){
                context.getExternalContext().getSessionMap().put("usuario", usuario);
                redireccion=redireccionar(usuario.getRol());
            }else{
                FacesMessage message;
                message=new FacesMessage("Usuario y/o contrasena incorrectos");
                context.addMessage(null, message);
            }
        }catch(Exception x){
            throw x;
        }
        return redireccion;
    }
    
    public String redireccionar(String rol){
        switch(rol){
            case "Administrador":
                return "indexAdmin";
            default:
                return "main";
        }
    }

    public void eliminarUsuario(Usuario usuario){
        String msj;
        try{
            UFL.remove(usuario);
            msj="Datos eliminados con exito";
        }catch(Exception x){
            msj="Error"+x.getMessage();
        }
        FacesMessage message=new FacesMessage(msj);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void editUser(){
        try{
            UFL.edit(usuario);   
        }catch(Exception x){
            throw x;
        }
        PrimeFaces.current().executeScript("PF('editF').hide()");
        PrimeFaces.current().ajax().update("form:dtUser");
    }
}
