package uiMain.operations;

import java.util.Scanner;
import BaseDatos.Data;
import gestorAplicacion.users.Paciente;
import gestorAplicacion.users.User;
import uiMain.OpcionDeMenu;
import gestorAplicacion.documents.Cita;
import gestorAplicacion.documents.Procedimiento;

public class ModificarCita extends OpcionDeMenu {
	public ModificarCita(String key) {
		super(key);
	}

	@Override
	public void ejecutar() {
		Scanner leer = new Scanner(System.in);
		System.out.print("Dijite el numero de la cita a modificar: ");
		String NC = leer.next();
		System.out.println("Seleccione una opción:");
		System.out.println("1: cambiar el estado de una cita");
		System.out.println("2: ingresar el procedimiento realizado en la cita");
		int OP = leer.nextInt();
		if (OP == 1) {
			System.out.println("Seleccione el estado:");
			System.out.println("1: Pendiente ");
			System.out.println("2: Realizada");
			int OP2 = leer.nextInt();
			if(OP2==1) {
				Cita C =Data.citasByN.get(NC);
				String FH= C.getFecha()+C.getHora();
				C.setEstado("pendiente");
				Data.citas.put(FH, C);
				Data.citasByN.put(NC, C);
			}else if (OP2 == 2) {
				Cita C =Data.citasByN.get(NC);
				String FH= C.getFecha()+C.getHora();
				C.setEstado("realizada");
				Data.citas.put(FH, C);
				Data.citasByN.put(NC, C);
			}
		} else if (OP == 2) {
			while(true) {
				System.out.print("Ingresar el procedimiento realizado en la cita: ");
				String P=leer.next();
				if(Data.proced.containsKey(P)) {
					Procedimiento PRO =Data.proced.get(P);
					Cita C =Data.citasByN.get(NC);
					String FH= C.getFecha()+C.getHora();
					C.setEstado("realizada");
					C.setProcedimiento(PRO);
					Data.citas.put(FH, C);
					Data.citasByN.put(NC, C);
					break;
				}
				else {
					System.out.println("El procedimiento ingresado es erroneo");
				}
			}
		}

	}

	@Override
	public String toString() {
		return "Modificar Cita";
	}

}
