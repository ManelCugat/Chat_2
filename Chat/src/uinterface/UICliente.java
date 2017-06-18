package uinterface;


import java.util.ArrayList;

import javax.swing.*;
import dominio.*;
import eventos.EventoUICliente;
import eventos.EventoBotonEnvio;

public class UICliente {
	

	private Usuario usuario;
	private JTextField textoEnvio, nick;
	private JComboBox<String> usuariosDisponibles;
	private JButton botonEnvio;
	private JTextArea campoChat;
	private ArrayList <Usuario> usuariosConectados;

	
	
	public UICliente(){
		
		MarcoCliente marcoCliente=new MarcoCliente();
		
		marcoCliente.addWindowListener(new EventoUICliente(usuario));
		
		marcoCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	private class MarcoCliente extends JFrame{
		
		private static final long serialVersionUID = 1L;

		public MarcoCliente(){
			
			this.setBounds(300, 300, 400, 450);
			
			this.setTitle("Cliente v.1");
			
			LaminaCliente laminaCliente=new LaminaCliente();
			
			this.add(laminaCliente);
			
			this.setVisible(true);
			
		}
		
	}

	private class LaminaCliente extends JPanel{
		
		private static final long serialVersionUID = 1L;

		public LaminaCliente(){
			
			usuario=new Usuario();
		
			usuario.setNick_name(JOptionPane.showInputDialog("Por favor, Introduce tu nickname"));
			
			nick=new JTextField(8);
			
			usuariosDisponibles = new JComboBox<String>();
		
			textoEnvio =new JTextField (30);
		
			campoChat=new JTextArea (20,30);
			
			JScrollPane scroll = new JScrollPane(campoChat);

			botonEnvio=new JButton("Enviar");
		
			nick.setText(usuario.getNick_name());
			
			nick.setEnabled(false);
			
			this.add(nick);
			
			this.add(usuariosDisponibles);
			
			this.add(scroll);
			
			this.add(textoEnvio);
			
			this.add(botonEnvio);
			
			addComboBoxUsuariosOnline ();
			
			botonEnvio.addActionListener(new EventoBotonEnvio (UICliente.this, getUsuario()));
		
		}
	
	}
	
	public void addComboBoxUsuariosOnline (/*ArrayList <Usuario> u*/){
		
		if (usuariosDisponibles.getItemCount()<1){
			
			usuariosDisponibles.addItem("No hay usuarios Online");
		}

		
		
	}

	
	
	public Usuario getUsuario (){
		
		return usuario;
		
	}
	
	public JTextField getTextoEnvio() {
		return textoEnvio;
	}


	public void setTextoEnvio(JTextField textoEnvio) {
		this.textoEnvio = textoEnvio;
	}


	public JTextArea getCampoChat() {
		return campoChat;
	}


	public void setCampoChat(JTextArea campoChat) {
		this.campoChat = campoChat;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



}