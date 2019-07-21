package uiMain.operations;

import uiMain.Main;
import uiMain.OpcionDeMenu;
import java.util.Scanner;
import BaseDatos.Data;
import gestorAplicacion.documents.Cita;
import gestorAplicacion.users.Empleado;
import gestorAplicacion.users.Paciente;
import gestorAplicacion.users.User;
import uiMain.OpcionDeMenu;

public class Renunciar extends OpcionDeMenu {
	public Renunciar(String key) {
		super(key);
	}

	@Override
	public void ejecutar() {
		Empleado E = (Empleado) Main.user;
		Scanner leer = new Scanner(System.in);
		while (true) {
			System.out.print("Ingrese el nombre de usuario nuevamente: ");
			String username = leer.next();
			System.out.print("Ingrese su contraseña nuevamente: ");
			String Password = leer.next();
			if (username.contentEquals(E.getUsername())&&Password.equals(E.getPassword())) {
				System.out.println("Validacion exitosa ");
				System.out.println("¿Seguro que desea continuar? (Si: 1, No: 2) :");
				int OP = leer.nextInt();
				if (OP == 1) {
					Data.users.remove(username);
					System.out.println("Renucia exitosa");
				}else if(OP==2){
					System.out.println("Renucia cancelada");
				}
				break;
			} else {
				System.out.println("Validacion fallida, por favor ingrese los datos nuevamente:  ");
			}
		}

	}

	@Override
	public String toString() {
		return "Renuncia";
	}

}
