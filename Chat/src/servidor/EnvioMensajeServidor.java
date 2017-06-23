package servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import dominio.PaqueteUsuariosOnline;

public class EnvioMensajeServidor {
	
	
	//Envio del los usuarios Online del Servidor al Cliente
	
	public void usuarioOnlineServidorCliente (PaqueteUsuariosOnline paqueteUsuariosOnline){
		
		try {
			
			Socket socket = new Socket (paqueteUsuariosOnline.getIpCliente(),8888);
			
			System.out.println("Se envía a la ip: " + paqueteUsuariosOnline.getIpCliente());
			
			ObjectOutputStream usuarioOnlineCliente = new ObjectOutputStream (socket.getOutputStream());
			
			System.out.print(paqueteUsuariosOnline.toString());
			
			usuarioOnlineCliente.writeObject(paqueteUsuariosOnline);

			usuarioOnlineCliente.close();
			
			socket.close();
			
			System.out.println("UsuarioOnline enviado del Servidor al cliente!");
			
		}catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
