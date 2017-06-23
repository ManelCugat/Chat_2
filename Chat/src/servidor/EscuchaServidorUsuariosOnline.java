package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import dominio.Usuario;
import dominio.UsuariosOnline;

public class EscuchaServidorUsuariosOnline implements Runnable{
	
	private UIServidor servidor;
	
	public EscuchaServidorUsuariosOnline (UIServidor servidor){
		
		this.servidor=servidor;
		
		Thread t = new Thread (this);
		
		t.start();
		
		
	}


	@SuppressWarnings("resource")
	public void run() {
		
			ServerSocket socketServidorUsuariosOnline=null;
			Socket socketUsuariosOnline;
			Usuario usuarioOnline;
			UsuariosOnline arrayUsuariosOnline = new UsuariosOnline();

	
			try {
	
				socketServidorUsuariosOnline = new ServerSocket (8888);
				
		
			} catch (IOException e) {
		
				e.printStackTrace();
			}
	
			while (true){
		
				try {
					
				
					/*Escucha de los usuarios que se van conectando*/
					
					socketUsuariosOnline = socketServidorUsuariosOnline.accept();
					
					ObjectInputStream recepcionUsuariosOnline = new ObjectInputStream (socketUsuariosOnline.getInputStream());
					
					usuarioOnline = (Usuario) recepcionUsuariosOnline.readObject();
					
					usuarioOnline.setIp(socketUsuariosOnline.getInetAddress());
					
					servidor.getAreaTexto().append("Usuario online recibido: " + usuarioOnline.toString() + "\n");
					
					arrayUsuariosOnline.addUsuarioOnline(usuarioOnline);
					
			
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


