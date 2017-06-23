package dominio;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.ArrayList;


public class PaqueteUsuariosOnline implements Serializable {

	private static final long serialVersionUID = 5710264500453408646L;
	
	//private ArrayList <Usuario> listadoUsuariosOnline;
	private InetAddress ipCliente;

	
	public PaqueteUsuariosOnline(ArrayList <Usuario> listadoUsuariosOnline, InetAddress ipCliente){
		
		//this.setListadoUsuariosOnline(listadoUsuariosOnline);
		this.setIpCliente(ipCliente);
	
	}


	/*public ArrayList <Usuario> getListadoUsuariosOnline() {
		return listadoUsuariosOnline;
	}


	public void setListadoUsuariosOnline(ArrayList <Usuario> listadoUsuariosOnline) {
		this.listadoUsuariosOnline = listadoUsuariosOnline;
	}*/



	public InetAddress getIpCliente() {
		return ipCliente;
	}


	public void setIpCliente(InetAddress ipCliente) {
		this.ipCliente = ipCliente;
	}
	
	
	public String toString(){
		
		return "La ip destino del paquete es: " + getIpCliente() + " la lista de Usuarios: \n";
	}




}
