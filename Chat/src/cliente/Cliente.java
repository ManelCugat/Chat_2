package cliente;

public class Cliente {

	public static void main(String[] args) {

		UICliente cliente=new UICliente();
		
		@SuppressWarnings("unused")
		EscuchaClienteUsuarioOnline escuchaClienteUsuarioOnline = new EscuchaClienteUsuarioOnline(cliente);
	
	
	}

}
