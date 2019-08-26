package uiMain.operations;

import java.util.Scanner;

import gestorAplicacion.users.User;
import uiMain.OpcionDeMenu;

public class SeeOpt extends OpcionDeMenu {//Sirve para ver todas las opciones de menú que se encuentran disponibles, todas y cada una
	
	public SeeOpt(String key){
		super(key);
	}
	
	@Override
	public void ejecutar() {//Hace print de todas y cada una de las opciones de menú con su respectivo Key
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
