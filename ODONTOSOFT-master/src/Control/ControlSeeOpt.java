package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import View.InterfazVista;
import errorAplication.NotFoundException;
import uiMain.operations.SeeOpt;
import View.PanelSeeOpt;
import View.VentanaPP;

public class ControlSeeOpt implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String ID = PanelSeeOpt.ID.getText();
		if (e.getActionCommand().equals(InterfazVista.ACEPTAR)) {
			try {
				if (!ID.equals("")) {
					ArrayList<String> opt = SeeOpt.ejecutar(ID);
					VentanaPP.contenedor.removeAll();
					VentanaPP.contenedor.add(new PanelSeeOpt(opt));
					VentanaPP.ventana.pack();
				}else {
					JOptionPane.showMessageDialog(null, "El campo identificacion del usuario no fue llenado","Campo vacio", JOptionPane.WARNING_MESSAGE);
				}
			} catch (NotFoundException EX) {
				JOptionPane.showMessageDialog(null, "No existe un usuario con la identificacion " + ID,
						"Usuario no encontrado", JOptionPane.WARNING_MESSAGE);
			}
		}

	}

}
