
package eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dominio.Envio;
import dominio.Mensaje;
import dominio.Usuario;
import uinterface.UICliente;

public class EventoBotonEnvio implements ActionListener{

	
	private UICliente cliente;
	private Usuario user;
	
	
	public EventoBotonEnvio (UICliente cliente, Usuario user){
		
	
		this.setCliente(cliente);
		this.setUser(user);
		
	}
	
	

	public void actionPerformed(ActionEvent e) {

		
		System.out.println("botón pulsado");
		
		Mensaje mensaje = new Mensaje();
		
		mensaje.setMensaje(cliente.getTextoEnvio().getText());
		mensaje.setUsuario(getUser());
		mensaje.setIpDestino(cliente.getUsuario().getIp());
	
		Envio mensajeEnvio = new Envio();
		
		mensajeEnvio.mensaje(mensaje);
	
	}



	public UICliente getCliente() {
		return cliente;
	}



	public void setCliente(UICliente cliente) {
		this.cliente = cliente;
	}



	public Usuario getUser() {
		return user;
	}



	public void setUser(Usuario user) {
		this.user = user;
	}
	
}
