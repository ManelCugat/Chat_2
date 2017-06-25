package cliente;


import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

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
		
		EnvioMensajeCliente envioMensajeCliente = new EnvioMensajeCliente();
		


		if (cliente.getBotonOnline().getText().equalsIgnoreCase("Conectar")){
			
			getUsuario().setOnline(true);
			
			try {
				
				envioMensajeCliente.usuarioOnlineClienteServidor(getUsuario());
				
				getCliente().getBotonOnline().setText("Desconectar");
				
				getCliente().getBotonEnvio().setEnabled(true);
				
			} catch (UnknownHostException e1) {
	
				getUsuario().setOnline(false);
			
				e1.printStackTrace();
				
			} catch (IOException e1) {
				
				getUsuario().setOnline(false);
				
				JOptionPane.showMessageDialog(cliente.getLamina(), "Servidor no disponible");
				
				cliente.getCampoChat().append(e1.toString());

				e1.printStackTrace();
			}
			
			
			
		} else{
			
		
			getUsuario().setOnline(false);
			
			try {
				
				envioMensajeCliente.usuarioOnlineClienteServidor(getUsuario());
				
				getCliente().getBotonOnline().setText("Conectar");
				
				getCliente().getBotonEnvio().setEnabled(false);
				
			} catch (UnknownHostException e1) {
	
				e1.printStackTrace();
				
			} catch (IOException e1) {
				
				JOptionPane.showMessageDialog(cliente.getLamina(), "Servidor no disponible");

				e1.printStackTrace();
			}
			
		
		}
		
		
	}
	
	
		

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
