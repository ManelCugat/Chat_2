package dominio;

import java.util.*;

public class UsuariosOnline {
	
	private ArrayList <Usuario> usuariosOnline = new ArrayList <Usuario>();
	
	
	public UsuariosOnline (){}
	
	
	public void addUsuarioOnline (Usuario u){
		
		System.out.println("valorando el usuario: " + u.toString());
		
		if (usuariosOnline.isEmpty()){
			
			usuariosOnline.add(u);
			u.setOnline(true);
			
		} else if (!estaEnArray(u)){

			usuariosOnline.add(u);
			u.setOnline(true);
			
		} else if (u.isOnline()==false){
			
			usuariosOnline.remove(posicionElementoQuitar(u));
			
		}
		
		System.out.println ("**** USUARIOS ONLINE ****");
	
		for (Usuario user:usuariosOnline){
			
			System.out.println(user);
			
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
	

}
