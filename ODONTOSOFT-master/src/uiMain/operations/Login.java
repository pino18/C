package uiMain.operations;

import java.util.Scanner;

import errorAplication.ErrorAplication;
import gestorAplicacion.users.User;
import uiMain.OpcionDeMenu;

public class Login extends OpcionDeMenu{//Iniciar sesi�n, pide las credenciales de el usuario que quiere ingresar, y hace la validaci�n mediante el metodo login de la clase User
	@Override
	public void ejecutar() {//Pide el usuario y contrase�a y hace el Login de manera valida en caso de que dicho nombre de usuario y dicha contrase�a si est�n ligados a un usuario registrado
		Scanner leer = new Scanner(System.in);
		System.out.print("Ingrese su nombre de usuario: ");
		String username = leer.next();
		System.out.print("Ingrese su contrase�a: ");
		String password = leer.next();
		try {
			System.out.println(User.login(username, password));
		}
		catch(ErrorAplication e) {
			System.out.println("Usuario o contrase�a no encontrado");
		}
	}

	@Override
	public String toString() {
		return "Iniciar sesi�n";
	}

}
