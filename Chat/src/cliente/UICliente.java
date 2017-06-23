package cliente;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

import dominio.*;

public class UICliente implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private JTextField textoEnvio, nick;
	private JComboBox<String> usuariosDisponibles;
	private JButton botonEnvio,botonOnline;
	private JTextArea campoChat;
	//private ArrayList <Usuario> usuariosConectados;
	private JPanel lamina;

	
	
	public UICliente(){
		
		
		usuario=new Usuario(this);
		
		MarcoCliente marcoCliente=new MarcoCliente();
	
		marcoCliente.addWindowListener(new EventoUICliente(usuario));
	
		marcoCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	private class MarcoCliente extends JFrame{
		
		private static final long serialVersionUID = 1L;

		public MarcoCliente(){
			
			this.setBounds(300, 300, 400, 500);
			
			this.setTitle("Cliente v.1");
			
			LaminaCliente laminaCliente=new LaminaCliente();
			
			this.add(laminaCliente);
			
			this.setVisible(true);
			
		}
		
	}

	private class LaminaCliente extends JPanel{
		
		private static final long serialVersionUID = 1L;

		public LaminaCliente(){
			
			setLamina(this);
			
			usuario.setNick_name(JOptionPane.showInputDialog("Por favor, Introduce tu nickname"));
			
			botonOnline=new JButton("Conectar");
			
			nick=new JTextField(8);
			
			usuariosDisponibles = new JComboBox<String>();
			
			usuariosDisponibles.addItem("No hay Usuarios Online");
		
			textoEnvio =new JTextField (30);
		
			campoChat=new JTextArea (20,30);
			
			JScrollPane scroll = new JScrollPane(campoChat);

			botonEnvio=new JButton("Enviar");
		
			nick.setText(usuario.getNick_name());
			
			nick.setEnabled(false);
			
			this.add(botonOnline);
			
			this.add(nick);
			
			this.add(usuariosDisponibles);
			
			this.add(scroll);
			
			this.add(textoEnvio);
			
			this.add(botonEnvio);
			
			botonOnline.addActionListener(new EventoBotonConectar (UICliente.this, getUsuario()));
			
			botonEnvio.addActionListener(new EventoBotonEnvio (UICliente.this, getUsuario()));
	
		}
		
	
	}
	
	public void addComboBoxUsuariosOnline (ArrayList <Usuario> u){
		

			Iterator <Usuario> it = u.iterator();
			
			Usuario user;

		
			while (it.hasNext()){
				
				user=it.next();
				
				usuariosDisponibles.addItem(user.getNick_name());
				
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
	
	public JButton getBotonOnline() {
		return botonOnline;
	}
	
	public void setBotonOnline(JButton botonOnline) {
		this.botonOnline = botonOnline;
	}



	public JPanel getLamina() {
		return lamina;
	}



	public void setLamina(JPanel lamina) {
		this.lamina = lamina;
	}



}