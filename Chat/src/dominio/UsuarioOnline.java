package dominio;

import java.io.Serializable;
import java.net.InetAddress;

public class UsuarioOnline implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nickName;
	private InetAddress ip;
	
	
	public UsuarioOnline (String nickName, InetAddress ip){
		
		this.setNickName(nickName);
		this.setIp(ip);
		
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public InetAddress getIp() {
		return ip;
	}


	public void setIp(InetAddress ip) {
		this.ip = ip;
	}
	
	public String toString (){
		
		
		return "Nickname: " + getNickName();
	
	}
	

}
