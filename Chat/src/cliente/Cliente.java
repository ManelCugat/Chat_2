package cliente;

public class Cliente {

	public static void main(String[] args) {

		UICliente cliente=new UICliente();
		
		@SuppressWarnings("unused")
		EscuchaClienteUsuarioOnline escuchaClienteUsuarioOnline = new EscuchaClienteUsuarioOnline(cliente);
		
		@SuppressWarnings("unused")
		EscuchaClienteMensaje escuchaClienteMensaje = new EscuchaClienteMensaje (cliente);
	
	}

}
