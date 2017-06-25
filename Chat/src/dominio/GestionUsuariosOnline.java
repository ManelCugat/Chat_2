package dominio;



import java.net.InetAddress;
import java.util.*;

import servidor.EnvioMensajeServidor;

public class GestionUsuariosOnline {
	

	
	private ArrayList <Usuario> usuariosOnlineServidor = new ArrayList <Usuario>();
	
	private ArrayList <UsuarioOnline> usuariosOnlineCliente = new ArrayList <UsuarioOnline>();
	
	
	public GestionUsuariosOnline (){}
	
	
	public void addUsuarioOnline (Usuario u){
		
		boolean modificacion=false;
		
		System.out.println("valorando el usuario: " + u.toString());
		
		if (usuariosOnlineServidor.isEmpty() && u.isOnline()){
			
			usuariosOnlineServidor.add(u);
			modificacion=true;
			
		} else if (!estaEnArray(u) && u.isOnline()){

			usuariosOnlineServidor.add(u);
			modificacion=true;
			
		} else if (estaEnArray(u) && !u.isOnline()){
			
			usuariosOnlineServidor.remove(posicionElementoQuitar(u));
			modificacion=true;
			
		}
		
		System.out.println ("**** USUARIOS ONLINE ****");
	
		for (Usuario user:usuariosOnlineServidor){
			
			System.out.println(user);
			
		}
		
		//Si hay modificación del array de usuarios Online se envían los usurios online al cliente
		
		if (modificacion){
			
			gestionActualizacionUsuariosOnlineServidor ();
			
		}
		
		
	}

	
	public void gestionActualizacionUsuariosOnlineServidor (){
		
		EnvioMensajeServidor envioServidor = new EnvioMensajeServidor();
		
		Iterator <Usuario> it = getArrayListUsuariosOnlineServidor().iterator();
		
		InetAddress ip;
		
		Usuario usuario;
		
		while (it.hasNext()){
			
			usuario = it.next();
			
			ip = usuario.getIp();
			
			for (Usuario u : getArrayListUsuariosOnlineServidor()){
				
					if (!u.getIp().equals(ip)){
						
					UsuarioOnline onlineUser = new UsuarioOnline(u.getNick_name(),u.getIp());
					
					getUsuariosOnlineCliente().add(onlineUser);
					

			
					}
			}
			
			PaqueteUsuariosOnline paqueteUsuariosOnline = new PaqueteUsuariosOnline(getUsuariosOnlineCliente(), ip);
			
			envioServidor.usuarioOnlineServidorCliente(paqueteUsuariosOnline);
			
			getUsuariosOnlineCliente().removeAll(getUsuariosOnlineCliente());
		
		}
	
	}
	
	
	public boolean estaEnArray (Usuario u){
		
		
		Iterator <Usuario>it = usuariosOnlineServidor.iterator();
		Usuario usuario;
		boolean contieneUsuario=false;
		
		
		while (it.hasNext()){
			
			usuario=it.next();
			
			if (usuario.getNick_name().equals(u.getNick_name())){
				
				contieneUsuario=true;
				
			}
			
		}
		
		return contieneUsuario;
		
	}
	
	
	public int posicionElementoQuitar (Usuario u){
		
		ListIterator <Usuario>it = usuariosOnlineServidor.listIterator();
		Usuario usuario;
		int i=0;
		int posicion=0;
		
		while (it.hasNext()){
			
			usuario=it.next();
			
			if (usuario.getNick_name().equals(u.getNick_name())){
				
				posicion=i;
				
			}
			
			i++;
			
		}
		
		return posicion;

	}
	
	public ArrayList <Usuario> getArrayListUsuariosOnlineServidor (){
		
		return usuariosOnlineServidor;
		
	}
	
	public String toString (){
		
		
		return getArrayListUsuariosOnlineServidor().toString();
		
		
	}


	public ArrayList <UsuarioOnline> getUsuariosOnlineCliente() {
		return usuariosOnlineCliente;
	}


	public void setUsuariosOnlineCliente(ArrayList <UsuarioOnline> usuariosOnlineCliente) {
		this.usuariosOnlineCliente = usuariosOnlineCliente;
	}
	

}
