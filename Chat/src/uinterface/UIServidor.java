package uinterface;

import javax.swing.*;


public class UIServidor {

	
	private JTextArea areaTexto;


	public UIServidor(){
		
		MarcoServidor marco =  new MarcoServidor();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	
	private class MarcoServidor extends JFrame{
		
		private static final long serialVersionUID = 1L;

		public MarcoServidor(){
			
			
			this.setBounds(1500, 300, 400, 550);
			
			this.setTitle("Servidor");
			
			LaminaServidor lamina=new LaminaServidor();
			
			this.add(lamina);
			
			this.setVisible(true);
			
		}
		
	}
	
	
	
	private class LaminaServidor extends JPanel{
		
		private static final long serialVersionUID = 1L;

		public LaminaServidor(){
			
		areaTexto = new JTextArea (32,31);
			
		JScrollPane scroll = new JScrollPane(areaTexto);

		this.add(scroll);
		
		}
		
		
	}

	
	public JTextArea getAreaTexto() {
		return areaTexto;
	}



	public void setAreaTexto(JTextArea areaTexto) {
		this.areaTexto = areaTexto;
	}
	
}




