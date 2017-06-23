package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import dominio.PaqueteUsuariosOnline;
import dominio.Usuario;

public class EscuchaClienteUsuarioOnline implements Runnable{
	
	private UICliente cliente;
	
	
	public EscuchaClienteUsuarioOnline (UICliente cliente){
		
		this.setCliente(cliente);
		
		Thread t = new Thread(this);
		
		t.start();
		
		
	}


	@SuppressWarnings("resource")
	public void run() {
		
		ServerSocket serverCliente=null;
		Socket socketCliente=null;
		PaqueteUsuariosOnline paqueteUsuariosOnline;
		ArrayList <Usuario> listaUsuarios;

		try {
			serverCliente = new ServerSocket(8888);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		while (true){
			
			try {
				
				socketCliente = serverCliente.accept();
				
				ObjectInputStream listaUsuariosRecibida = new ObjectInputStream (socketCliente.getInputStream());
			
				paqueteUsuariosOnline = (PaqueteUsuariosOnline) listaUsuariosRecibida.readObject();
				
				listaUsuariosRecibida.close();
				
				socketCliente.close();
				
				cliente.getCampoChat().append("Recibe el cliente: "+ paqueteUsuariosOnline.getIpCliente());
				//listaUsuarios = paqueteUsuariosOnline.getUsuariosOnline().getArrayListUsuariosOnline();
				
				//cliente = paqueteUsuariosOnline.getUsuario().getCliente();
				
				//cliente.addComboBoxUsuariosOnline(listaUsuarios);
				
			
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
