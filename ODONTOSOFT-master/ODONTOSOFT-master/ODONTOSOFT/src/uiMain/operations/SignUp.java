package uiMain.operations;

import java.util.Scanner;
import gestorAplicacion.users.Paciente;
import gestorAplicacion.users.Acompaniante;
import gestorAplicacion.users.User;
import uiMain.OpcionDeMenu;

public class SignUp extends OpcionDeMenu {
	@Override
	public void ejecutar() {
		Scanner leer = new Scanner(System.in);
		String username = "";
		String password = "";
		while(true) {
			System.out.print("Ingrese su nombre de usuario: ");
			username = leer.next();
			if (User.getUserByUsername(username)!= null) {
				System.out.println("Usuario ya existente");
				continue;
			}
			System.out.print("Ingrese su contraseña: ");
			password = leer.next();
			System.out.print("Verifique su contraseña: ");
			if (!password.equals(leer.next())) {
				System.out.println("Las contraseñas no coinciden");
				continue;
			}
			break;
		}
		System.out.print("Ingrese su nombre y apellido: ");
		String fullname = leer.nextLine();
		System.out.print("Ingrese su identificación: ");
		String identificacion = leer.next();
		System.out.print("Ingrese su edad: ");
		String edad = leer.next();
		System.out.print("Ingrese su telefono: ");
		String telefono = leer.next();
		System.out.print("Ingrese su sexo: ");
		String sexo = leer.next();
		System.out.print("Ingrese su email: ");
		String email = leer.next();
		System.out.print("Usted es : 1 Paciente | 2 Acompañante| 3 Invitado \n");
		String usur = leer.next();
		switch(usur) {
			case "1":
				System.out.print(User.newUser(new Paciente(), identificacion, fullname, edad, telefono, sexo, username, email, password));
				System.out.println(User.login(username, password));
				break;
			case "2":
				String usurpa="";
				while(true) {
					System.out.print("Ingrese el usuario de quien usted es acompañante: ");
					usurpa = leer.next();
					if (User.getUserByUsername(username)==null) {
						System.out.print("El usuario no existe ");
						continue;
					}
					break;
				}
				System.out.print("Ingrese el parentezco: ");
				String parentezco = leer.next();
				System.out.print(User.newUser(new Acompaniante(usurpa, parentezco), identificacion, fullname, edad, telefono, sexo, username, email, password));
				System.out.println(User.login(username, password));
				break;
			default:
				System.out.print(User.newUser(new User(), identificacion, fullname, edad, telefono, sexo, username, email, password));
				System.out.println(User.login(username, password));
				break;
		}
	}

	@Override
	public String toString() {
		return "Registrarse";
	}

}
