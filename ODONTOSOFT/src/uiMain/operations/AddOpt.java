package uiMain.operations;

import java.util.Scanner;

import gestorAplicacion.users.User;
import uiMain.OpcionDeMenu;

public class AddOpt extends OpcionDeMenu{
	
	public AddOpt(String key){
		super(key);
	}
	
	@Override
	public void ejecutar() {
		Scanner leer = new Scanner(System.in);
		System.out.print("Ingrese el nombre de usuario: ");
		String username = leer.next();
		User user = User.getUserByUsername(username);
		OpcionDeMenu.seeAllOperations();
		System.out.print("Ingrese el numero de la funcionalidad a añadir: ");
		String opt = leer.next();
		user.getMenu().añadirOpcion(opt);
	}

	@Override
	public String toString() {
		return "Añadir funcionalidades a un usuario";
	}

}
