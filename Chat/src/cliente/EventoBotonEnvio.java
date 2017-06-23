
package cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dominio.PaqueteMensaje;
import dominio.Usuario;

public class EventoBotonEnvio implements ActionListener{

	
	private UICliente cliente;
	private Usuario user;
	
	
	public EventoBotonEnvio (UICliente cliente, Usuario user){
		
	
		this.setCliente(cliente);
		this.setUser(user);
		
	}
	
	

	public void actionPerformed(ActionEvent e) {

		
		System.out.println("botón pulsado");
		
		PaqueteMensaje mensaje = new PaqueteMensaje();
		
		mensaje.setMensaje(cliente.getTextoEnvio().getText());
		mensaje.setUsuario(getUser());
		mensaje.setIpDestino(cliente.getUsuario().getIp());
		
		cliente.getCampoChat().append(getUser().getNick_name() +": " +cliente.getTextoEnvio().getText() + "\n");
		
		cliente.getTextoEnvio().setText("");
		
		
		EnvioMensajeCliente mensajeEnvio = new EnvioMensajeCliente();
		
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
