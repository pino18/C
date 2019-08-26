package uiMain.operations;

import java.util.Scanner;

import BaseDatos.Data;
import gestorAplicacion.users.AdminUser;
import gestorAplicacion.users.User;
import gestorAplicacion.users.Empleado;
import uiMain.OpcionDeMenu;

public class NewEmpleado extends OpcionDeMenu {//Se crea un nuevo usuario de tipo empleado haciendo llamado del constructor de empleado que recibe los parametros pedidos los cuales son a la vez las credenciales del usuario
	
	public NewEmpleado(String key){
		super(key);
	}
	
	@Override
	public void ejecutar() {//Hace pedido de todas las credenciales necesarias para la creación de un usuario de tipo empleado, las guarda en la base de datos y hace validación de la información ingresada
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
		String fullname = leer.next();
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
		System.out.print("Ingrese su contrato: ");
		String contrato = leer.next();
		System.out.print("Ingrese su cargo: ");
		String cargo = leer.next();
		System.out.print("Ingrese su sueldo: ");
		int sueldo = leer.nextInt();
		System.out.print("Ingrese su horario: ");
		String horario = leer.next();
		System.out.println(User.newUser(new Empleado(contrato, cargo, sueldo, horario), identificacion, fullname, edad, telefono, sexo, username, email, password));
	}

	@Override
	public String toString() {
		return "Crear nuevo usuario empleado";
	}

}
