package cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import dominio.Usuario;

public class EventoBotonConectar implements ActionListener{

	
	private UICliente cliente;
	
	private Usuario usuario;
	
	private boolean conectado;
	
	
	public EventoBotonConectar (UICliente cliente, Usuario usuario){
		
		
		this.setCliente(cliente);
		
		this.setUsuario(usuario);
		
		
	}
	

	public void actionPerformed(ActionEvent e) {
		

		if (cliente.getBotonOnline().getText().equalsIgnoreCase("Conectar")){
			
			getUsuario().setOnline(true);
			
			try {
				
				envioNotificacionOnline();
				
				getCliente().getBotonOnline().setText("Desconectar");
				
			} catch (UnknownHostException e1) {
	
				getUsuario().setOnline(false);
			
				e1.printStackTrace();
				
			} catch (IOException e1) {
				
				getUsuario().setOnline(false);
				
				JOptionPane.showMessageDialog(cliente.getLamina(), "Servidor no disponible");

				e1.printStackTrace();
			}
			
			
			
		} else{
			
		
			getUsuario().setOnline(false);
			
			try {
				
				envioNotificacionOnline();
				
				getCliente().getBotonOnline().setText("Conectar");
				
			} catch (UnknownHostException e1) {
	
				e1.printStackTrace();
				
			} catch (IOException e1) {
				
				JOptionPane.showMessageDialog(cliente.getLamina(), "Servidor no disponible");

				e1.printStackTrace();
			}
			
		
		}
		
		
	}
	
	
	public void envioNotificacionOnline () throws UnknownHostException, IOException{
		
			
			Socket socketEnvioUsuarioOnline = new Socket ("192.168.1.99",8888);
			
			ObjectOutputStream envioOnline = new ObjectOutputStream (socketEnvioUsuarioOnline.getOutputStream());
			
			envioOnline.writeObject(getUsuario());
			
			envioOnline.close();
			
			socketEnvioUsuarioOnline.close();
			
			
		} /*catch (UnknownHostException e1) {
			
			
			e1.printStackTrace();
			
		} catch (IOException e1) {
			
			System.out.println("Error enviando usuario Online!!!!!");
			
			JOptionPane.showMessageDialog(cliente.getLamina(), "Servidor no disponible");
			
			getUsuario().setOnline(false);
			
			e1.printStackTrace();
		}
		
		}else{
			
	
			getCliente().getBotonOnline().setText("Conectar");
			
			
		}*/
		
	


	public UICliente getCliente() {
		return cliente;
	}


	public void setCliente(UICliente cliente) {
		this.cliente = cliente;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public boolean isConectado() {
		return conectado;
	}


	public void setConectado(boolean conectado) {
		this.conectado = conectado;
	}

}
