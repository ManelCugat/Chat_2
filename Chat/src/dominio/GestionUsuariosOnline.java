package dominio;


import java.io.Serializable;
import java.util.*;

import servidor.EnvioMensajeServidor;

public class UsuariosOnline implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList <Usuario> usuariosOnline = new ArrayList <Usuario>();
	
	
	public UsuariosOnline (){}
	
	
	public void addUsuarioOnline (Usuario u){
		
		boolean modificacion=false;
		
		System.out.println("valorando el usuario: " + u.toString());
		
		if (usuariosOnline.isEmpty() && u.isOnline()){
			
			usuariosOnline.add(u);
			modificacion=true;
			
		} else if (!estaEnArray(u) && u.isOnline()){

			usuariosOnline.add(u);
			modificacion=true;
			
		} else if (estaEnArray(u) && !u.isOnline()){
			
			usuariosOnline.remove(posicionElementoQuitar(u));
			modificacion=true;
			
		}
		
		System.out.println ("**** USUARIOS ONLINE ****");
	
		for (Usuario user:usuariosOnline){
			
			System.out.println(user);
			
		}
		
		//Si hay modificación del array de usuarios Online se envían los usurios online al cliente
		
		if (modificacion){
			
			EnvioMensajeServidor envioServidor = new EnvioMensajeServidor();
			
			PaqueteUsuariosOnline paqueteUsuariosOnline = new PaqueteUsuariosOnline (this.getArrayListUsuariosOnline(),u.getIp());
			
			System.out.println("Se produce una modificación en lista de usuarios Online!!!");
			
			System.out.println("Se crea el paquete de usuarios Online!!!");
		
			envioServidor.usuarioOnlineServidorCliente(paqueteUsuariosOnline);
			
		}
		
		
	}
	
	public boolean estaEnArray (Usuario u){
		
		
		Iterator <Usuario>it = usuariosOnline.iterator();
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
		
		ListIterator <Usuario>it = usuariosOnline.listIterator();
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
	
	public ArrayList <Usuario> getArrayListUsuariosOnline (){
		
		return usuariosOnline;
		
	}
	
	public String toString (){
		
		
		return getArrayListUsuariosOnline().toString();
		
		
	}
	

}
