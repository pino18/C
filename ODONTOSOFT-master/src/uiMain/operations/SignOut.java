package uiMain.operations;
import gestorAplicacion.users.User;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class SignOut  extends OpcionDeMenu{//Función Cerrar Sesión
	
	public SignOut(String key){
		super(key);
	}
	
	@Override
	public void ejecutar() {//Printea el mensaje Adios para hacer enfasis en que la sesión ha sido cerrada correctamente
		System.out.println("Adios");
		User.currentUser = null;
		
	}

	@Override
	public String toString() {
		return "Cerrar Sesión";
	}

}
