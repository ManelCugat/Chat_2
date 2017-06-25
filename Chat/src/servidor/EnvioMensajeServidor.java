package servidor;

import java.io.*;
import java.net.*;

import dominio.PaqueteUsuariosOnline;
import dominio.Usuario;
import dominio.UsuarioServCliente;

public class EnvioMensajeServidor implements Serializable{
	
	
	//Envio del los usuarios Online del Servidor al Cliente
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void usuarioOnlineServidorCliente (PaqueteUsuariosOnline p){
		
		try {
			
			Socket socket = new Socket (p.getIp(),8888);
			
			System.out.println("************Actualización de Usuarios enviados*********");
			
			System.out.println(p.toString());
		
			ObjectOutputStream usuarioOnlineCliente = new ObjectOutputStream (socket.getOutputStream());
	
			usuarioOnlineCliente.writeObject(p);

			usuarioOnlineCliente.close();
			
			socket.close();
			
		}catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
