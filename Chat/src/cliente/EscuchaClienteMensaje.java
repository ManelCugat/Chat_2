package cliente;


import java.io.*;
import java.net.*;

import dominio.PaqueteMensaje;

public class EscuchaClienteMensaje implements Runnable{

	private UICliente cliente;
	
	public EscuchaClienteMensaje (UICliente cliente){
		
		this.setCliente(cliente);
		
		Thread t = new Thread (this);
		
		t.start();
		
		
	}
	
	

	@SuppressWarnings("resource")
	public void run() {
		
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		PaqueteMensaje mensaje;
		
		try {
			serverSocket = new ServerSocket (9999);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (true){
			
			try {
				
				socket = serverSocket.accept();
				
				ObjectInputStream mensajeRecibido = new ObjectInputStream (socket.getInputStream());
				
				mensaje = (PaqueteMensaje) mensajeRecibido.readObject();
	
				mensajeRecibido.close();
				
				socket.close();
				
				getCliente().getCampoChat().append(mensaje.getNickName()+ ": "+mensaje.getMensaje() +"\n");;
			
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			
			
		}
		
	}



	public UICliente getCliente() {
		return cliente;
	}



	public void setCliente(UICliente cliente) {
		this.cliente = cliente;
	}

}
