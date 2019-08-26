package uiMain.operations;

import java.util.Scanner;
import BaseDatos.Data;
import gestorAplicacion.users.Paciente;
import uiMain.OpcionDeMenu;
import gestorAplicacion.documents.Cita;
import gestorAplicacion.documents.HistoriaClinica;
import gestorAplicacion.documents.Procedimiento;
import gestorAplicacion.documents.Recibo;

public class ModificarCita extends OpcionDeMenu {//Modifica el estado y/o procedimiento a realizar de una cita existente para llevar actualizada la base de datos
	public ModificarCita(String key) {
		super(key);
	}

	@Override
	public void ejecutar() {//Pide la información que se desea cambiar de la cita, para poder hacer los cambios de manera valida, se puede elegir entre los distintos procedimientos que hace la compañia o en el caso que una cita ya se haya realizado cambia su estado de pendiente a realizada
		Scanner leer = new Scanner(System.in);
		while (true) {
			System.out.print("Digite el numero de la cita a modificar: ");
			String NC = leer.next();
			if (Data.citasByN.containsKey(NC)) {
				System.out.println("Seleccione una opcion:");
				System.out.println("1: cambiar el estado de una cita");
				System.out.println("2: ingresar el procedimiento realizado en la cita");
				int OP = leer.nextInt();
				if (OP == 1) {
					System.out.println("Seleccione el estado a cambiar:");
					System.out.println("1: Pendiente ");
					System.out.println("2: Realizada");
					int OP2 = leer.nextInt();
					if (OP2 == 1) {
						Cita C = Data.citasByN.get(NC);
						String FH = C.getFecha() + C.getHora();
						C.setEstado("pendiente");
						Data.citas.put(FH, C);
						Data.citasByN.put(NC, C);
					} else if (OP2 == 2) {
						while (true) {
							System.out.print("Ingresar el procedimiento realizado en la cita: ");
							String input = leer.next();
							if (Data.proced.containsKey(input)) {
								Procedimiento PRO = Data.proced.get(input);
								Cita C = Data.citasByN.get(NC);
								String FH = C.getFecha() + C.getHora();
								C.setEstado("realizada");
								C.setProcedimiento(PRO);
								Paciente P = C.getPaciente();
								HistoriaClinica H = Data.historias.get(P.getIdentificacion());
								H.AddNroCitasRealizadas();
								Data.historias.put(H.getID(), H);
								Data.citas.put(FH, C);
								Data.citasByN.put(NC, C);
								System.out.print("Modificacion exitosa ");
								String IDRecibo;
								while (true) {
									IDRecibo  = Recibo.GenNroRecibo();
									if (IDRecibo != null) {
										break;
									}
								}
								Recibo R = new Recibo(IDRecibo,"pendiente",PRO);
								Data.reci.put(IDRecibo, R);
								
								break;
							} else {
								System.out.println("El procedimiento ingresado es erroneo");
							}
						}
						

					}
				} else if (OP == 2) {
					while (true) {
						System.out.print("Ingresar el procedimiento realizado en la cita: ");
						String input = leer.next();
						if (Data.proced.containsKey(input)) {
							Procedimiento PRO = Data.proced.get(input);
							Cita C = Data.citasByN.get(NC);
							String FH = C.getFecha() + C.getHora();
							if (C.getProcedimiento().getTipo().equals("ninguno")) {
								C.setEstado("realizada");
							}
							C.setProcedimiento(PRO);
							Paciente P = C.getPaciente();
							HistoriaClinica H = Data.historias.get(P.getIdentificacion());
							H.AddNroCitasRealizadas();
							Data.historias.put(H.getID(), H);
							Data.citas.put(FH, C);
							Data.citasByN.put(NC, C);
							System.out.print("Modificacion exitosa ");
							String IDRecibo;
							while (true) {
								IDRecibo  = Recibo.GenNroRecibo();
								if (IDRecibo != null) {
									break;
								}
							}
							Recibo R = new Recibo(IDRecibo,"pendiente",PRO);
							Data.reci.put(IDRecibo, R);
							break;
						} else {
							System.out.println("El procedimiento ingresado es erroneo");
						}
					}
				}
			}else {
				System.out.println("La cita ingresada no se encuentra en el sistema");

			}
		}
	}

	@Override
	public String toString() {
		return "Modificar Cita";
	}

}
