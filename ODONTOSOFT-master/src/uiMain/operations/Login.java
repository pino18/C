package uiMain.operations;

import java.util.Scanner;

import errorAplication.ErrorAplication;
import gestorAplicacion.users.User;
import uiMain.OpcionDeMenu;

public class Login extends OpcionDeMenu{//Iniciar sesión, pide las credenciales de el usuario que quiere ingresar, y hace la validación mediante el metodo login de la clase User
	@Override
	public void ejecutar() {//Pide el usuario y contraseña y hace el Login de manera valida en caso de que dicho nombre de usuario y dicha contraseña si estén ligados a un usuario registrado
		Scanner leer = new Scanner(System.in);
		System.out.print("Ingrese su nombre de usuario: ");
		String username = leer.next();
		System.out.print("Ingrese su contraseña: ");
		String password = leer.next();
		try {
			System.out.println(User.login(username, password));
		}
		catch(ErrorAplication e) {
			System.out.println("Usuario o contraseña no encontrado");
		}
	}

	@Override
	public String toString() {
		return "Iniciar sesión";
	}

}
