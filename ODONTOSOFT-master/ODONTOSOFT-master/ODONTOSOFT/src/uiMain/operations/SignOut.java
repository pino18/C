package uiMain.operations;
import uiMain.Main;
import uiMain.OpcionDeMenu;

public class SignOut  extends OpcionDeMenu{
	
	public SignOut(String key){
		super(key);
	}
	
	@Override
	public void ejecutar() {
		System.out.println("Adios");
		Main.user = null;
		
	}

	@Override
	public String toString() {
		return "Cerrar Sesión";
	}

}
