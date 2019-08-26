package uiMain.operations;

import java.util.Scanner;
import BaseDatos.Data;
import gestorAplicacion.users.Empleado;
import gestorAplicacion.users.Paciente;
import gestorAplicacion.users.User;
import uiMain.OpcionDeMenu;
import gestorAplicacion.documents.Cita;
import gestorAplicacion.documents.Procedimiento;

public class SolicitarCita extends OpcionDeMenu {//El metodo solicitar cita hace reservaci�n de citas dada su fecha y hora, hace revisi�n de la disponibilidad de horario para la cita solicitada, dado que si hay una cita agendada para una fecha y hora especifica no puedan haber repeticiones
	public SolicitarCita(String key) {
		super(key);
	}

	@Override
	public void ejecutar() {//EJecuta todas las operaciones como validacio de usuario y hace peticion de los valores necesarios para agendar la cita, dicese de Hora, Fecha, Sede Etc.
		Scanner leer = new Scanner(System.in);
		while (true) {
			System.out.print("Ingrese el nombre de usuario nuevamente: ");
			String username = leer.next();
			Paciente Paciente = (Paciente) User.getUserByUsername(username);
			System.out.print("Ingrese su contrase�a nuevamente: ");
			String Password = leer.next();
			if (Password.equals(Paciente.getPassword())) {
				System.out.println("Validacion exitosa ");

				while (true) {
					System.out.print("Ingrese la fecha de la cita (dd/mm/aa): ");
					String Fecha = leer.next();
					System.out.print("Ingrese la hora de la cita (hh:00 o hh:30)(24h): ");
					String Hora = leer.next();
					String NroCita;
					if (!Data.citasByN.containsKey(Fecha + Hora)) {
						while (true) {
							NroCita = Cita.GenNroCita();
							if (NroCita != null) {
								break;
							}
						}
						System.out.print("Seleccione el lugar de la cita:" + '\n' + "1: Laureles " + '\n'
								+ "2: Poblado " + '\n');
						int L = leer.nextInt();
						String Lugar;
						if (L == 1) {
							Lugar = "laureles";
						} else {
							Lugar = "poblado";
						}
						System.out.print("Seleccione el tipo de consulta:" + '\n' + "1: General " + '\n'
								+ "2: Prioritaria " + '\n');
						int TC = leer.nextInt();
						String TipoConsulta;
						if (TC == 1) {
							TipoConsulta = "general";
						} else {
							TipoConsulta = "prioritaria";
						}
						String Estado = "Pendiente";
						Procedimiento Procedimiento = new Procedimiento("pendiente", 0);
						String Empleado;
						if (Lugar.equals("laureles") || Lugar.equals("poblado")) {
							String h = Integer.toString(Hora.charAt(0)) + Integer.toString(Hora.charAt(1));
							int H = Integer.parseInt(h);
							if (H <= 12) {
								Empleado e = (Empleado) Data.users.get("emple1");
								Empleado=e.getUsername();
							} else {
								Empleado e = (Empleado) Data.users.get("emple2");
								Empleado=e.getUsername();
							}
						} else {
							String h = Integer.toString(Hora.charAt(0)) + Integer.toString(Hora.charAt(1));
							int H = Integer.parseInt(h);
							if (H <= 12) {
								Empleado e= (Empleado) Data.users.get("emple3");
								Empleado=e.getUsername();
							} else {
								Empleado e= (Empleado) Data.users.get("emple4");
								Empleado=e.getUsername();
							}
						}
						new Cita(NroCita, Fecha, Hora, Lugar, Paciente, TipoConsulta, Estado, Procedimiento, Empleado);
						System.out.println("Cita solicitada Exitosamente, su numero de cita es: "+NroCita);
						break;
					} else {
						System.out.println(
								"el horario que usted ha solicitado no se encuentra disponible, ingrese una nueva cita");
					}
				}
				break;
			}
			else {
				System.out.println("Validacion fallida, por favor ingrese los datos nuevamente:  ");

			}
		}

	}

	@Override
	public String toString() {
		return "Solicitud de Cita";
	}

}
