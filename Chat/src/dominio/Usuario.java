package dominio;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nick_name;
	private boolean isOnline;
	private InetAddress ip;

	public Usuario () {
		
		try {
			setIp(InetAddress.getLocalHost());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
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
	

}
