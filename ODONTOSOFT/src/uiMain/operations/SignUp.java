package uiMain.operations;

import java.util.Scanner;
import gestorAplicacion.users.Paciente;
import gestorAplicacion.users.Acompa�ante;
import gestorAplicacion.users.User;
import uiMain.OpcionDeMenu;

public class SignUp extends OpcionDeMenu {
	@Override
	public void ejecutar() {
		Scanner leer = new Scanner(System.in);
		System.out.print("Ingrese su nombre y apellido: ");
		String fullname = leer.next();
		System.out.print("Ingrese su identificaci�n: ");
		String identificacion = leer.next();
		System.out.print("Ingrese su edad: ");
		String edad = leer.next();
		System.out.print("Ingrese su telefono: ");
		String telefono = leer.next();
		System.out.print("Ingrese su sexo: ");
		String sexo = leer.next();
		System.out.print("Ingrese su nombre de usuario: ");
		String username = leer.next();
		System.out.print("Ingrese su email: ");
		String email = leer.next();
		System.out.print("Ingrese su contrase�a: ");
		String password = leer.next();
		System.out.print("Usted es : 1 Paciente | 2 Acompa�ante\n");
		String usur = leer.next();
		switch(usur) {
			case "1":
				System.out.print(User.newUser(new Paciente(), identificacion, fullname, edad, telefono, sexo, username, email, password));
				System.out.print(User.login(username, password));
				break;
			case "2":
				System.out.print("Ingrese el usuario de quien usted es acompa�ante: ");
				String usurpa = leer.next();
				System.out.print("Ingrese el parentezco: ");
				String parentezco = leer.next();
				System.out.print(User.newUser(new Acompa�ante(usurpa, parentezco), identificacion, fullname, edad, telefono, sexo, username, email, password));
				System.out.print(User.login(username, password));
				break;
			default:
				System.out.print(User.newUser(new User(), identificacion, fullname, edad, telefono, sexo, username, email, password));
				System.out.print(User.login(username, password));
				break;
		}
	}

	@Override
	public String toString() {
		return "Registrarse";
	}

}
