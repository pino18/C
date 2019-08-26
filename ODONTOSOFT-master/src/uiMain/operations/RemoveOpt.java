package uiMain.operations;

import java.util.Scanner;

import gestorAplicacion.users.User;
import uiMain.OpcionDeMenu;

public class RemoveOpt extends OpcionDeMenu{//Remueve una opci�n de men� de un usuario
	
	public RemoveOpt(String key){
		super(key);
	}
	
	@Override
	public void ejecutar() {//Hace una validacion mediante el nombre de usuario al que se quiere eliminar una opci�n de menu, luego mediante la Key de la opci�n de men� se hace la eliminaci�n de la misma
		Scanner leer = new Scanner(System.in);
		System.out.print("Ingrese el nombre de usuario: ");
		String username = leer.next();
		User user = User.getUserByUsername(username);
		user.getMenu().seeOpt();
		System.out.print("Ingrese el numero de la funcionalidad a remover: ");
		int index = leer.nextInt();
		user.getMenu().removeOpt(index);
	}

	@Override
	public String toString() {
		return "Quitar funcionalidades de un usuario";
	}

}
