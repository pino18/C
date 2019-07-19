package uiMain.operations;
import java.util.Scanner;
import BaseDatos.Data;
import gestorAplicacion.users.User;
import uiMain.OpcionDeMenu;
import gestorAplicacion.documents.Cita;
public class SolicitarCita extends OpcionDeMenu{
	public SolicitarCita(String key){
		super(key);
	}

	@Override
	public void ejecutar() {
		Scanner leer = new Scanner(System.in);
		System.out.print("Ingrese el nombre de usuario: ");
		String username = leer.next();
		User user = User.getUserByUsername(username);
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
