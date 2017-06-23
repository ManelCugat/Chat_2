package servidor;

import java.io.*;
import java.net.*;

import dominio.PaqueteMensaje;

public class EscuchaServidorMensaje implements Runnable{
	
	
	private UIServidor servidor;
	
	
	public EscuchaServidorMensaje (UIServidor servidor){
		
		
		this.servidor=servidor;
		
		Thread t = new Thread (this);
		
		t.start();
		
	}
	
	
		@SuppressWarnings("resource")
		
		public void run() {

			ServerSocket socketServidor = null;
			Socket socket = null;
			PaqueteMensaje mensaje;


	
			try {
		
				socketServidor = new ServerSocket (9999);
				System.out.println("El servidor se activa");
				
		
			} catch (IOException e) {
		
				e.printStackTrace();
			}
	
			while (true){
		
				try {
					
					/*Escucha de mensajes provinientes de los clientes*/
					System.out.println("Esperando mensaje");
					
					socket = socketServidor.accept();
					
					System.out.println("Mensaje recibido");
			
					ObjectInputStream recepcion = new ObjectInputStream(socket.getInputStream());
			
					mensaje= (PaqueteMensaje) recepcion.readObject();
					
					servidor.getAreaTexto().append(mensaje.toString() + "\n");
					
			
				} catch (IOException e) {
			
					System.out.println("----ERROR: Socket Servidor----");
			
					e.printStackTrace();
		
				} catch (ClassNotFoundException e) {
			
					System.out.println("----ERROR: Creando el mensaje recepcionado por el Servidor----");
			
					e.printStackTrace();
				}
		
			}	
	
		}

}



