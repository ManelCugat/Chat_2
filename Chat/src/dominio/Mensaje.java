package dominio;

import java.io.Serializable;
import java.net.InetAddress;

public class Mensaje implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private String mensaje;
	private InetAddress ipDestino;
	
	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public InetAddress getIpDestino() {
		return ipDestino;
	}


	public void setIpDestino(InetAddress ipDestino) {
		this.ipDestino = ipDestino;
	}

	
	public String toString(){
		
		return " De: " + getUsuario().getNick_name() + " Mensaje enviado: " + getMensaje() + 
				" Para: " + getIpDestino();
		
	}
	

}
