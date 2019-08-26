package uiMain.operations;

import java.util.Scanner;
import BaseDatos.Data;
import gestorAplicacion.users.Paciente;
import gestorAplicacion.users.User;
import uiMain.OpcionDeMenu;
import gestorAplicacion.documents.Cita;

public class CancelarCita extends OpcionDeMenu {//Cancela una cita agendada en el sistema y la elimina de la base de datos dejando libre dicho horario para otra cita
	public CancelarCita(String key) {
		super(key);
	}

	@Override
	public void ejecutar() {//Hace una validación para asegurarse que el usuario si es el que quiere cancelar la cita, luego pide la información de la cita para poder buscarla en la base de datos y así hacer el proceso de borrado
		Scanner leer = new Scanner(System.in);
		
		while (true) {
			System.out.print("Ingrese el nombre de usuario nuevamente: ");
			String username = leer.next();
			Paciente Paciente = (Paciente) User.getUserByUsername(username);
			System.out.print("Ingrese su contraseña nuevamente: ");
			String Password = leer.next();
			if (Password.equals(Paciente.getPassword())) {
				System.out.println("Validacion exitosa ");
				System.out.println("Seleccione una de las opciones de busqueda:");
				System.out.println("1: Busqueda por numero de cita:");
				System.out.println("2: Busqueda fecha y hora:");
				int OP=leer.nextInt();
				if(OP==1) {
					System.out.print("Digite en numero de cita: ");
					String NC=leer.next();
					Cita C = Data.citasByN.get(NC);
					Data.citasByN.remove(NC);
					String FH= C.getFecha()+C.getHora();
					Data.citas.remove(FH);
					System.out.println("Cancelacion exitosa");
				}
				else if(OP==2){
					System.out.print("Ingrese la fecha de la cita (dd/mm/aa): ");
					String Fecha = leer.next();
					System.out.print("Ingrese la hora de la cita (hh:00 o hh:30)(24h): ");
					String Hora = leer.next();
					Cita C = Data.citas.get(Fecha+Hora);
					Data.citas.remove(Fecha+Hora);
					Data.citasByN.remove(C.getNroCita());
					System.out.println("Cancelacion exitosa");
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
		return "Cancelar Cita";
	}

}
