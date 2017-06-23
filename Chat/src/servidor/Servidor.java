package servidor;

public class Servidor {
	

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		UIServidor servidor = new UIServidor();
	
		EscuchaServidorUsuariosOnline s = new EscuchaServidorUsuariosOnline(servidor);
		
		EscuchaServidorMensaje m = new EscuchaServidorMensaje (servidor);
		
	}
	
}


	
