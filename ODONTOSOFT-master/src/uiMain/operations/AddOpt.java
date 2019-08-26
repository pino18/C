package uiMain.operations;

import java.util.Scanner;

import gestorAplicacion.users.User;
import uiMain.OpcionDeMenu;

public class AddOpt extends OpcionDeMenu{//A�ade una opc�on de men� a un usuario que no ten�a dicha funcionalidad anteriormente
	
	public AddOpt(String key){
		super(key);
	}
	
	@Override
	public void ejecutar() {//busca el usuario por su username y le muestra al administrador todas las opciones de men� que tiene disponible y que puede agregar al usuario en cuesti�n,
		Scanner leer = new Scanner(System.in);
		System.out.print("Ingrese el nombre de usuario: ");
		String username = leer.next();
		User user = User.getUserByUsername(username);
		OpcionDeMenu.seeAllOperations1();
		System.out.print("Ingrese el numero de la funcionalidad a a�adir: ");
		String opt = leer.next();
		user.getMenu().a�adirOpcion(opt);
		System.out.print("FUncionalidad a�adida ");
	}

	@Override
	public String toString() {
		return "A�adir funcionalidades a un usuario";
	}

}
