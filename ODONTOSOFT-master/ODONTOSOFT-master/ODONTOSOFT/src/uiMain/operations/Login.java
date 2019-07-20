package uiMain.operations;

import java.util.Scanner;

import gestorAplicacion.users.User;
import uiMain.OpcionDeMenu;

public class Login extends OpcionDeMenu{
	@Override
	public void ejecutar() {
		Scanner leer = new Scanner(System.in);
		System.out.print("Ingrese su usuario: ");
		String username = leer.next();
		System.out.print("Ingrese su contraseña: ");
		String password = leer.next();
		
		System.out.println(User.login(username, password));
		
	}

	@Override
	public String toString() {
		return "Iniciar sesión";
	}

}
