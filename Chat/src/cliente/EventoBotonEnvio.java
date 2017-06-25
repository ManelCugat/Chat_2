
package cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;

import dominio.PaqueteMensaje;
import dominio.Usuario;
import dominio.UsuarioOnline;

public class EventoBotonEnvio implements ActionListener{

	
	private UICliente cliente;
	private Usuario user;
	private InetAddress ipDestino;
	
	
	public EventoBotonEnvio (UICliente cliente, Usuario user){
		
	
		this.setCliente(cliente);
		this.setUser(user);
		
	}
	
	

	public void actionPerformed(ActionEvent e) {

		
		System.out.println("botón pulsado");
		
		PaqueteMensaje mensaje = new PaqueteMensaje();
		
		mensaje.setMensaje(cliente.getTextoEnvio().getText());
		mensaje.setNickName(user.getNick_name());
		mensaje.setIpDestino(ipClienteDestino(cliente.getUsuariosOnline()));
		
		cliente.getCampoChat().append(getUser().getNick_name() +": " +cliente.getTextoEnvio().getText() + "\n");
		
		cliente.getTextoEnvio().setText("");
		
		
		EnvioMensajeCliente mensajeEnvio = new EnvioMensajeCliente();
		
		mensajeEnvio.mensaje(mensaje);
		

	
	}
	
	
	public InetAddress ipClienteDestino (ArrayList <UsuarioOnline> uo){
		
		InetAddress ipDestino=null;
		
		String nickName = (String) getCliente().getUsuariosDisponibles().getSelectedItem();
		
		Iterator <UsuarioOnline> it = uo.iterator();
		
		while (it.hasNext()){
			
			UsuarioOnline usuario = it.next();
			
			if (usuario.getNickName().equalsIgnoreCase(nickName)){
				
				ipDestino = usuario.getIp();
				
			}
			
		}
	
		return ipDestino;
		
	}



	public UICliente getCliente() {
		return cliente;
	}



	public void setCliente(UICliente cliente) {
		this.cliente = cliente;
	}



	public Usuario getUser() {
		return user;
	}



	public void setUser(Usuario user) {
		this.user = user;
	}
	
}
