package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BaseDatos.Data;
import View.PanelInicio;
import View.PanelLogin;
import View.PanelRegistrar;
import View.PanelRemoveOpt;
import View.PanelSolicitarCita;
import View.VentanaPP;
import View.FieldPanel.FieldPanel;
import gestorAplicacion.documents.Cita;
import gestorAplicacion.documents.Procedimiento;
import gestorAplicacion.users.Empleado;
import gestorAplicacion.users.Paciente;
import gestorAplicacion.users.User;

public class ControlSolicitarCita implements ActionListener {
//se lleva a cabo la asignacin de la cita haciendo uso del constructor de la clase cita
//los valores pasados a ese constructor salen de todo este controlador, el cual depende básicamente de
//el lugar y el tipo de cita, por eso existen 4 posibilidades	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<String> values = PanelSolicitarCita.field.getValues();
		String lugar;
		String consulta;
		String username = values.get(0);
		Paciente Paciente = (Paciente) User.getUserByUsername(username);
		String fecha = values.get(1);
		String hora = values.get(2);
		if (values.contains("")) {
			JOptionPane.showMessageDialog(null, "No has llenado todos los campos", "ERROR", JOptionPane.ERROR_MESSAGE);
			values.clear();
			fecha = null;
			hora = null;

		} else {
//if de laureles para la cita en este lugar
			if (PanelSolicitarCita.lugar.getSelectedItem().equals("Laureles")) {
				lugar = "Laureles";

//if consulta general en laureles				
				if (PanelSolicitarCita.consulta.getSelectedItem().equals("General")) {
					consulta = "General";
					String NroCita;
					if (!Data.citasByN.containsKey(fecha + hora)) {
						while (true) {
							NroCita = Cita.GenNroCita();
							if (NroCita != null) {
								break;
							}
						}
						String Estado = "Pendiente";
						Procedimiento Procedimiento = new Procedimiento("pendiente", 0);
						String Empleado;
						if (lugar.equals("Laureles")) {
							String h = Integer.toString(hora.charAt(0)) + Integer.toString(hora.charAt(1));
							int H = Integer.parseInt(h);
							if (H <= 12) {
								Empleado em = (Empleado) Data.users.get("emple1");
								Empleado = em.getUsername();
							} else {
								Empleado em = (Empleado) Data.users.get("emple2");
								Empleado = em.getUsername();
							}
						} else {
							String h = Integer.toString(hora.charAt(0)) + Integer.toString(hora.charAt(1));
							int H = Integer.parseInt(h);
							if (H <= 12) {
								Empleado em = (Empleado) Data.users.get("emple3");
								Empleado = em.getUsername();
							} else {
								Empleado em = (Empleado) Data.users.get("emple4");
								Empleado = em.getUsername();
							}
						}
						new Cita(NroCita, fecha, hora, lugar, Paciente, consulta, Estado, Procedimiento, Empleado);
						JOptionPane.showMessageDialog(null, "Su numero de cita es: " + NroCita, "Proceso Exitoso",
								JOptionPane.INFORMATION_MESSAGE);
						NroCita = null;
						fecha = null;
						hora = null;
						lugar = null;
						Paciente = null;
						consulta = null;
						Estado = null;
						Procedimiento = null;
						Empleado = null;
						VentanaPP.contenedor.removeAll();
						VentanaPP.contenedor.add(new PanelLogin());
						VentanaPP.ventana.pack();
						PanelRegistrar.Field = new FieldPanel();
						values.clear();
					} else {
						JOptionPane.showMessageDialog(null,
								"el horario que usted ha solicitado no se encuentra disponible, ingrese una nueva cita",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					}

				}
//if cnsulta prioritaria en laureles				
				else if (PanelSolicitarCita.consulta.getSelectedItem().equals("Prioritaria")) {
					consulta = "Prioritaria";
					String NroCita;
					if (!Data.citasByN.containsKey(fecha + hora)) {
						while (true) {
							NroCita = Cita.GenNroCita();
							if (NroCita != null) {
								break;
							}
						}
						String Estado = "Pendiente";
						Procedimiento Procedimiento = new Procedimiento("pendiente", 0);
						String Empleado;
						if (lugar.equals("Laureles")) {
							String h = Integer.toString(hora.charAt(0)) + Integer.toString(hora.charAt(1));
							int H = Integer.parseInt(h);
							if (H <= 12) {
								Empleado em = (Empleado) Data.users.get("emple1");
								Empleado = em.getUsername();
							} else {
								Empleado em = (Empleado) Data.users.get("emple2");
								Empleado = em.getUsername();
							}
						} else {
							String h = Integer.toString(hora.charAt(0)) + Integer.toString(hora.charAt(1));
							int H = Integer.parseInt(h);
							if (H <= 12) {
								Empleado em = (Empleado) Data.users.get("emple3");
								Empleado = em.getUsername();
							} else {
								Empleado em = (Empleado) Data.users.get("emple4");
								Empleado = em.getUsername();
							}
						}
						new Cita(NroCita, fecha, hora, lugar, Paciente, consulta, Estado, Procedimiento, Empleado);
						JOptionPane.showMessageDialog(null, "Su numero de cita es: " + NroCita, "Proceso Exitoso",
								JOptionPane.INFORMATION_MESSAGE);
						NroCita = null;
						fecha = null;
						hora = null;
						lugar = null;
						Paciente = null;
						consulta = null;
						Estado = null;
						Procedimiento = null;
						Empleado = null;
						VentanaPP.contenedor.removeAll();
						VentanaPP.contenedor.add(new PanelLogin());
						VentanaPP.ventana.pack();
						PanelRegistrar.Field = new FieldPanel();
						values.clear();
					} else {
						JOptionPane.showMessageDialog(null,
								"el horario que usted ha solicitado no se encuentra disponible, ingrese una nueva cita",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					}

				}
				else if(PanelSolicitarCita.consulta.getSelectedItem().equals("---")) {
					JOptionPane.showMessageDialog(null,
							"Seleccione el tipo de consulta",
							"ERROR", JOptionPane.ERROR_MESSAGE);
					
				}

			}
// if del poblado			
			if (PanelSolicitarCita.lugar.getSelectedItem().equals("Poblado")) {
				lugar = "Poblado";

//if consulta general en poblado				
				if (PanelSolicitarCita.consulta.getSelectedItem().equals("General")) {
					consulta = "General";
					String NroCita;
					if (!Data.citasByN.containsKey(fecha + hora)) {
						while (true) {
							NroCita = Cita.GenNroCita();
							if (NroCita != null) {
								break;
							}
						}
						String Estado = "Pendiente";
						Procedimiento Procedimiento = new Procedimiento("pendiente", 0);
						String Empleado;
						if (lugar.equals("Poblado")) {
							String h = Integer.toString(hora.charAt(0)) + Integer.toString(hora.charAt(1));
							int H = Integer.parseInt(h);
							if (H <= 12) {
								Empleado em = (Empleado) Data.users.get("emple1");
								Empleado = em.getUsername();
							} else {
								Empleado em = (Empleado) Data.users.get("emple2");
								Empleado = em.getUsername();
							}
						} else {
							String h = Integer.toString(hora.charAt(0)) + Integer.toString(hora.charAt(1));
							int H = Integer.parseInt(h);
							if (H <= 12) {
								Empleado em = (Empleado) Data.users.get("emple3");
								Empleado = em.getUsername();
							} else {
								Empleado em = (Empleado) Data.users.get("emple4");
								Empleado = em.getUsername();
							}
						}
						new Cita(NroCita, fecha, hora, lugar, Paciente, consulta, Estado, Procedimiento, Empleado);
						JOptionPane.showMessageDialog(null, "Su numero de cita es: " + NroCita, "Proceso Exitoso",
								JOptionPane.INFORMATION_MESSAGE);
						NroCita = null;
						fecha = null;
						hora = null;
						lugar = null;
						Paciente = null;
						consulta = null;
						Estado = null;
						Procedimiento = null;
						Empleado = null;
						VentanaPP.contenedor.removeAll();
						VentanaPP.contenedor.add(new PanelLogin());
						VentanaPP.ventana.pack();
						PanelRegistrar.Field = new FieldPanel();
						values.clear();
					} else {
						JOptionPane.showMessageDialog(null,
								"el horario que usted ha solicitado no se encuentra disponible, ingrese una nueva cita",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					}

				}
//if cnsulta prioritaria en poblado				
				else if (PanelSolicitarCita.consulta.getSelectedItem().equals("Prioritaria")) {
					consulta = "Prioritaria";
					String NroCita;
					if (!Data.citasByN.containsKey(fecha + hora)) {
						while (true) {
							NroCita = Cita.GenNroCita();
							if (NroCita != null) {
								break;
							}
						}
						String Estado = "Pendiente";
						Procedimiento Procedimiento = new Procedimiento("pendiente", 0);
						String Empleado;
						if (lugar.equals("Poblado")) {
							String h = Integer.toString(hora.charAt(0)) + Integer.toString(hora.charAt(1));
							int H = Integer.parseInt(h);
							if (H <= 12) {
								Empleado em = (Empleado) Data.users.get("emple1");
								Empleado = em.getUsername();
							} else {
								Empleado em = (Empleado) Data.users.get("emple2");
								Empleado = em.getUsername();
							}
						} else {
							String h = Integer.toString(hora.charAt(0)) + Integer.toString(hora.charAt(1));
							int H = Integer.parseInt(h);
							if (H <= 12) {
								Empleado em = (Empleado) Data.users.get("emple3");
								Empleado = em.getUsername();
							} else {
								Empleado em = (Empleado) Data.users.get("emple4");
								Empleado = em.getUsername();
							}
						}
						new Cita(NroCita, fecha, hora, lugar, Paciente, consulta, Estado, Procedimiento, Empleado);
						JOptionPane.showMessageDialog(null, "Su numero de cita es: " + NroCita, "Proceso Exitoso",
								JOptionPane.INFORMATION_MESSAGE);
						NroCita = null;
						fecha = null;
						hora = null;
						lugar = null;
						Paciente = null;
						consulta = null;
						Estado = null;
						Procedimiento = null;
						Empleado = null;
						VentanaPP.contenedor.removeAll();
						VentanaPP.contenedor.add(new PanelLogin());
						VentanaPP.ventana.pack();
						PanelRegistrar.Field = new FieldPanel();
						values.clear();
					} else {
						JOptionPane.showMessageDialog(null,
								"el horario que usted ha solicitado no se encuentra disponible, ingrese una nueva cita",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					}

				}
				else if(PanelSolicitarCita.consulta.getSelectedItem().equals("---")) {
					JOptionPane.showMessageDialog(null,
							"Seleccione el tipo de consulta",
							"ERROR", JOptionPane.ERROR_MESSAGE);
					
				}

			}
			if (PanelSolicitarCita.lugar.getSelectedItem().equals("---")) {
				JOptionPane.showMessageDialog(null,
						"Seleccione una de nuestras Sedes",
						"ERROR", JOptionPane.ERROR_MESSAGE);
				
			}

		}

	}

}
