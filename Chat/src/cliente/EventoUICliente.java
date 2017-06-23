package eventos;

import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import dominio.Envio;
import dominio.Mensaje;
import dominio.Usuario;
import uinterface.UICliente;

public class EventoUICliente extends WindowAdapter{
	
	private Usuario user;
	
	
	public EventoUICliente (Usuario user){
		
		this.setUser(user);
	
	}
	
	
	public void windowOpened (WindowEvent e){
		

		
		
	}
	
	public void windowActivated (WindowEvent e){
		
		System.out.println("ventana Abierta");
		
		Envio envio = new Envio();
		
		envio.usuarioOnline(user);
		

	}
	
	public void windowClosing(WindowEvent e){
		
		System.out.println("ventana Cerrada");
		
		getUser().setOnline(false);
		
		System.out.println(user.toString());
		
		Envio envio = new Envio();
		
		envio.usuarioOnline(user);
		
	}


	public Usuario getUser() {
		return user;
	}


	public void setUser(Usuario user) {
		this.user = user;
	}
	

}


