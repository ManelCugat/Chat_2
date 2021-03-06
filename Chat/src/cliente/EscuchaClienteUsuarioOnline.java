package cliente;

import java.io.*;
import java.net.*;
import java.util.*;

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
		PaqueteUsuariosOnline p;
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
			
				p = (PaqueteUsuariosOnline) listaUsuariosRecibida.readObject();
				
				listaUsuariosRecibida.close();
				
				socketCliente.close();
		
				getCliente().addComboBoxUsuariosOnline(p.getListadoUsuariosOnline());
				
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
