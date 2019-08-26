package uiMain.operations;

import java.util.Scanner;

import errorAplication.ErrorAplication;
import gestorAplicacion.users.Paciente;
import gestorAplicacion.documents.HistoriaClinica;
import gestorAplicacion.users.Acompaniante;
import gestorAplicacion.users.User;
import uiMain.OpcionDeMenu;

public class SignUp extends OpcionDeMenu {//Cumple la función de registrar usuarios nuevos que serán guardados en la base de datos
	@Override
	public void ejecutar() {//Guarda todas las credenciales del usuario que se va a registrar y tambien hace una diferenciación entre tipo de usuario, ya sea de tipo Paciente o de tipo Acompañante
		Scanner leer = new Scanner(System.in);
		String username = "";
		String password = "";
		String usur="";
		while(true) {
			System.out.print("Usted es : 1 Paciente | 2 Acompañante");
			usur = leer.next();
			if (!usur.equals("1")&&!usur.equals("2")) {
				System.out.println("Opcion incorrecta");
				continue;
			}
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
		System.out.print("Ingrese su nombre y apellido: (Sin Espacios)");
		String fullname = leer.next();
		System.out.print("Ingrese su identificacion: ");
		String identificacion = leer.next();
		System.out.print("Ingrese su edad: ");
		String edad = leer.next();
		System.out.print("Ingrese su telefono: ");
		String telefono = leer.next();
		System.out.print("Ingrese su sexo: ");
		String sexo = leer.next();
		System.out.print("Ingrese su email: ");
		String email = leer.next();
		
		switch(usur) {
			case "1":
				System.out.print(User.newUser(new Paciente(), identificacion, fullname, edad, telefono, sexo, username, email, password));
				try {
					System.out.println(User.login(username, password));
				}
				catch(ErrorAplication e) {
					System.out.println("Usuario o contraseña no encontrado");
				}
				new HistoriaClinica(identificacion,username,0,"ninguna");
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
				try {
					System.out.println(User.login(username, password));
				}
				catch(ErrorAplication e) {
					System.out.println("Usuario o contraseña no encontrado");
				}
				break;
			default:
				break;
		}
	}

	@Override
	public String toString() {
		return "Registrarse";
	}

}
