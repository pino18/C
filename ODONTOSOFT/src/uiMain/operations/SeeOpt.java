package uiMain.operations;

import java.util.Scanner;

import gestorAplicacion.users.User;
import uiMain.OpcionDeMenu;

public class SeeOpt extends OpcionDeMenu {
	
	public SeeOpt(String key){
		super(key);
	}
	
	@Override
	public void ejecutar() {
		Scanner leer = new Scanner(System.in);
		System.out.print("Ingrese el nombre de usuario: ");
		String username = leer.next();
		User user = User.getUserByUsername(username);
		user.getMenu().seeOpt();
	}

	@Override
	public String toString() {
		return "ver funciones de un usuario";
	}

}
