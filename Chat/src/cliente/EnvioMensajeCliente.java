package cliente;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import dominio.PaqueteMensaje;
import dominio.Usuario;

public class EnvioMensajeCliente {
	

	private PaqueteMensaje mensaje;
	private Socket socket;
	
	
	public EnvioMensajeCliente(){}
		
	
	public void mensaje (PaqueteMensaje mensaje)	{
		
		
		System.out.println("El mensaje que se envia es: " + mensaje.toString());
		
		try {
			
			socket =new Socket ("192.168.1.99",9999);
			
			ObjectOutputStream envio = new ObjectOutputStream (socket.getOutputStream());
			
			envio.writeObject(mensaje);
			
			envio.close();
			
			socket.close();
			
		} catch (IOException e) {
			
			System.out.println("----ERROR: Enviando Mensaje a Servidor----");
			
		}
		
	}
	

	public PaqueteMensaje getMensaje() {
		return mensaje;
	}

	public void setMensaje(PaqueteMensaje mensaje) {
		this.mensaje = mensaje;
	}
	
	
	//Envio del usuario Online del Cliente al Servidor
	
	public void usuarioOnlineClienteServidor(Usuario u){
		
	
		try {
			
			Socket socket = new Socket ("192.168.1.99",8888);
			
			System.out.println("Se abre socket usuario online");
			
			ObjectOutputStream usuarioOnlineServidor = new ObjectOutputStream (socket.getOutputStream());
			
			System.out.println("Se envia usuario: " + u.toString());
			
			usuarioOnlineServidor.writeObject(u);
			
			usuarioOnlineServidor.close();
			
			socket.close();
			
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
		

		

	
	

}
