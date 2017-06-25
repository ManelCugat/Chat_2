package dominio;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

import cliente.UICliente;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nick_name;
	private boolean isOnline;
	private InetAddress ip;
	
	public Usuario () {
		
		try {
			setIp(InetAddress.getLocalHost());
		} catch (UnknownHostException e) {

			e.printStackTrace();
		}
		

		this.setOnline(false);

	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public boolean isOnline() {
		return isOnline;
	}

	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	

	public InetAddress getIp() {
		return ip;
	}

	public void setIp(InetAddress ip) {
		this.ip = ip;
	}
	
	
	public String toString (){
		
		return "Nick_Name = " + getNick_name() + " InetAddress= " + ip.getHostAddress() + " Online: " +isOnline;
		
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nick_name == null) ? 0 : nick_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nick_name == null) {
			if (other.nick_name != null)
				return false;
		} else if (!nick_name.equals(other.nick_name))
			return false;
		return true;
	}


	

}
