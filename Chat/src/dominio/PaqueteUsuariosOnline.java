package dominio;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.ArrayList;


public class PaqueteUsuariosOnline implements Serializable {

	private static final long serialVersionUID = 5710264500453408646L;
	
	private ArrayList <UsuarioOnline> listadoUsuariosOnline;
	private InetAddress ip;

	
	public PaqueteUsuariosOnline(ArrayList <UsuarioOnline> listadoUsuariosOnline, InetAddress ipCliente){
		
		this.setListadoUsuariosOnline(listadoUsuariosOnline);
		this.setIp(ipCliente);
	
	}



	public ArrayList <UsuarioOnline> getListadoUsuariosOnline() {
		return listadoUsuariosOnline;
	}


	public void setListadoUsuariosOnline(ArrayList <UsuarioOnline> listadoUsuariosOnline) {
		this.listadoUsuariosOnline = listadoUsuariosOnline;
	}


	public InetAddress getIp() {
		return ip;
	}


	public void setIp(InetAddress ip) {
		this.ip = ip;
	}

	public String toString(){
		
		return "La ip destino del paquete es: " + getIp() + " la lista de Usuarios: \n" +
				getListadoUsuariosOnline().toString();
	}




}
