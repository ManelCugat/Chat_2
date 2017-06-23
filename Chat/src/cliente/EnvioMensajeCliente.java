package dominio;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Envio {
	
	/**
	 * 
	 */

	private Mensaje mensaje;
	private Socket socket;
	
	
	public Envio(){}
		
	
	public void mensaje (Mensaje mensaje)	{
		
		
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
	

	public Mensaje getMensaje() {
		return mensaje;
	}

	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}
	
	
	public void usuarioOnline(Usuario u){
		
	
		try {
			
			Socket socket = new Socket ("192.168.1.99",8888);
			
			System.out.println("Se abre socket usuario online");
			
			ObjectOutputStream usuarioOnline = new ObjectOutputStream (socket.getOutputStream());
			
			System.out.println("Se envia usuario: " + u.toString());
			
			usuarioOnline.writeObject(u);
			
			usuarioOnline.close();
			
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
