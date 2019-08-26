package uiMain.operations;

import uiMain.Main;
import uiMain.OpcionDeMenu;

import java.util.Map;
import java.util.Scanner;
import BaseDatos.Data;
import gestorAplicacion.documents.Cita;
import gestorAplicacion.users.Empleado;
import gestorAplicacion.users.Paciente;
import gestorAplicacion.users.User;
import uiMain.OpcionDeMenu;

public class Renunciar extends OpcionDeMenu {// Hace la solicitúd de renuncia de un empleado registrado
	public Renunciar(String key) {
		super(key);
	}

	@Override
	public void ejecutar() {// Hace la validación de usuario para poder confirmar que el usuario es el
							// empleado que quiere renunciar, luego envia un mensaje de confirmación para
							// asegurarse que el empleado si quiere renunciar
		try {
			Empleado E = (Empleado) User.currentUser;
			Scanner leer = new Scanner(System.in);

			while (true) {
				System.out.print("Ingrese el nombre de usuario nuevamente: ");
				String username = leer.next();
				System.out.print("Ingrese su contraseña nuevamente: ");
				String Password = leer.next();
				if (username.contentEquals(E.getUsername()) && Password.equals(E.getPassword())) {
					System.out.println("Validacion exitosa ");
					System.out.println("¿Seguro que desea continuar? (Si: 1, No: 2) :");
					int OP = leer.nextInt();
					if (OP == 1) {
						E = (Empleado) Data.users.get(username);
						if (E.getCargo().equals("medico")) {
							for (Map.Entry<String, Cita> Cita : Data.citas.entrySet()) {
								Cita CObj = Cita.getValue();
								if (CObj.getEmpleado().equals(username) && CObj.getEstado().equals("pendiente")) {
									String N = CObj.getNroCita();
									Data.citasByN.remove(N);
									Data.citas.remove(CObj.getFecha() + CObj.getHora());
								}
							}
						}
						Data.users.remove(username);
						System.out.println("Renucia exitosa");
					} else if (OP == 2) {
						System.out.println("Renucia cancelada");
					}
					break;
				} else {
					System.out.println("Validacion fallida, por favor ingrese los datos nuevamente:  ");
				}
			}
		} catch (Exception e) {
			System.out.println("No puedes renunciar porque no eres un empleado");
		}

	}

	@Override
	public String toString() {
		return "Renuncia";
	}

}
