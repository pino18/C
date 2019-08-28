package uiMain.operations;

import java.util.Scanner;

import gestorAplicacion.users.User;
import uiMain.OpcionDeMenu;

public class AddOpt extends OpcionDeMenu{//Añade una opcíon de menú a un usuario que no tenía dicha funcionalidad anteriormente
	
	public AddOpt(String key){
		super(key);
	}
	
	@Override
	public void ejecutar() {//busca el usuario por su username y le muestra al administrador todas las opciones de menú que tiene disponible y que puede agregar al usuario en cuestión,
		Scanner leer = new Scanner(System.in);
		System.out.print("Ingrese el nombre de usuario: ");
		String username = leer.next();
		User user = User.getUserByUsername(username);
		OpcionDeMenu.seeAllOperations1();
		System.out.print("Ingrese el numero de la funcionalidad a añadir: ");
		String opt = leer.next();
		user.getMenu().añadirOpcion(opt);
		System.out.print("FUncionalidad añadida ");
	}
	static public void ejecutar(String OP, String username) {//busca el usuario por su username y le muestra al administrador todas las opciones de menú que tiene disponible y que puede agregar al usuario en cuestión,
		User user = User.getUserByUsername(username);
		user.getMenu().añadirOpcion(OP);
	}

	@Override
	public String toString() {
		return "Añadir funcionalidades a un usuario";
	}

}
