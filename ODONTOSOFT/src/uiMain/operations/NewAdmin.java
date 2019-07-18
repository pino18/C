package uiMain.operations;

import java.util.Scanner;

import BaseDatos.Data;
import gestorAplicacion.users.AdminUser;
import gestorAplicacion.users.User;
import uiMain.OpcionDeMenu;

public class NewAdmin extends OpcionDeMenu {
	
	public NewAdmin(String key){
		super(key);
	}
	
	@Override
	public void ejecutar() {
		Scanner leer = new Scanner(System.in);
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
		System.out.print("Ingrese su nombre de usuario: ");
		String username = leer.next();
		System.out.print("Ingrese su email: ");
		String email = leer.next();
		System.out.print("Ingrese su contraseña: ");
		String password = leer.next();
		AdminUser.newAdminUser(identificacion, fullname, edad, telefono, sexo, username, email, password);
	}

	@Override
	public String toString() {
		return "Crear nuevo usuario admin";
	}

}
