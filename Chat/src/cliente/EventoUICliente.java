package cliente;

import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import dominio.PaqueteMensaje;
import dominio.Usuario;

public class EventoUICliente extends WindowAdapter{
	
	private Usuario user;
	
	
	public EventoUICliente (Usuario user){
		
		this.setUser(user);
	
	}
	
	
	
	public void windowClosing(WindowEvent e){
		
		if (getUser().isOnline()){
		
			getUser().setOnline(false);
		
			System.out.println(user.toString());
		
			EnvioMensajeCliente envio = new EnvioMensajeCliente();
		
			getUser().setOnline(false);
		
			try {
				envio.usuarioOnlineClienteServidor(getUser());
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		
	}


	public Usuario getUser() {
		return user;
	}


	public void setUser(Usuario user) {
		this.user = user;
	}
	

}


