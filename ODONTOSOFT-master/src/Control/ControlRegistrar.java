package Control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import View.PanelInicio;
import View.PanelRegistrar;
import View.VentanaPP;
import gestorAplicacion.documents.HistoriaClinica;
import gestorAplicacion.users.Acompaniante;
import gestorAplicacion.users.Paciente;
import gestorAplicacion.users.User;

public class ControlRegistrar implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		ArrayList<String> values = PanelRegistrar.Field.getValues();
		int size = values.size();
		if (size==0) {
			JOptionPane.showMessageDialog(null, "Por favor elija algún tipo de usuario", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		else if(values.contains("")) {
			JOptionPane.showMessageDialog(null, "Por favor llene todos los campos", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		else if (size==8) {
			if (User.getUserByUsername(values.get(5))==null) {
				User.newUser(new Paciente(),values.get(0),values.get(1),values.get(2),values.get(3),values.get(4),values.get(5),values.get(6),values.get(7));
				new HistoriaClinica(values.get(0),values.get(5),0,"Nada por el momento");
				JOptionPane.showMessageDialog(null, "El usuario Paciente se ha creado con exito", "Bienvenido a ODONTOSOFT", JOptionPane.INFORMATION_MESSAGE);
				VentanaPP.contenedor.removeAll();
				VentanaPP.contenedor.add(new PanelInicio());
				VentanaPP.ventana.pack();
			}
			else {
				JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese nombre", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if (size==10) {
			Paciente paciente = (Paciente) User.getUserByUsername(values.get(8));
			if (User.getUserByUsername(values.get(5))==null) {
				if (paciente != null) {
					if (paciente.getAcompaniante() != null) {
						User.newUser(new Acompaniante(values.get(8), values.get(9)), values.get(0), values.get(1),
								values.get(2), values.get(3), values.get(4), values.get(5), values.get(6),
								values.get(7));
						JOptionPane.showMessageDialog(null, "El usuario Acompañante se ha creado con exito", "Bienvenido a ODONTOSOFT", JOptionPane.INFORMATION_MESSAGE);
						VentanaPP.contenedor.removeAll();
						VentanaPP.contenedor.add(new PanelInicio());
						VentanaPP.ventana.pack();
					} else {
						JOptionPane.showMessageDialog(null, "El paciente ya tiene un acompañante", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "El usuario del paciente no existe", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese nombre", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}

}
