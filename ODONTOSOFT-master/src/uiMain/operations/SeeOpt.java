package uiMain.operations;

import java.util.Scanner;
import java.util.ArrayList;
import errorAplication.NotFoundException;
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
	/*Retorna un array con las opciones de menu que el ingresado usuario tiene de momento*/
	public static ArrayList<String> ejecutar(String ID) throws NotFoundException  {
		User user = User.getUserByUsername(ID);
		if(user!=null) {
			return user.getMenu().seeOpt1();
		}throw new NotFoundException();
	}
	
	@Override
	public String toString() {
		return "ver funciones de un usuario";
	}

}
