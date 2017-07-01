package servidor;

/* versión v0.1*/

public class Servidor {
	

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		UIServidor servidor = new UIServidor();
	
		EscuchaServidorUsuariosOnline s = new EscuchaServidorUsuariosOnline(servidor);
		
		EscuchaServidorMensaje m = new EscuchaServidorMensaje (servidor);
		
	}
	
}


	
