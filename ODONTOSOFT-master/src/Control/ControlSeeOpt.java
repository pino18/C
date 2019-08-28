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
//Este controlador premite modificar el panel de Ver opciones de usuario


public class ControlSeeOpt implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String ID = PanelSeeOpt.ID.getText();
		if (e.getActionCommand().equals(InterfazVista.ACEPTAR)) {
			try {
				if (!ID.equals("")) {
					/*Este if valida que la persona llene 
					el campo nombre de usuario del panel ver opciones*/
					
					ArrayList<String> opt = SeeOpt.ejecutar(ID);
					VentanaPP.contenedor.removeAll();
					VentanaPP.contenedor.add(new PanelSeeOpt(opt));
					VentanaPP.ventana.pack();
				}else {
					/*Arroja una ventana emergente en caso de que la persona
					 no llene el campo nombre de usuario donde da una alerta*/
					JOptionPane.showMessageDialog(null, "El campo identificacion del usuario no fue llenado","Campo vacio", JOptionPane.WARNING_MESSAGE);
				}
			} catch (NotFoundException EX) {
				/*Este catch se encarga de arrojar una ventana emergente
				  en caso de que el programa arroje un error por haber 
				  ingresado un nombre de usuario que no existe*/
				JOptionPane.showMessageDialog(null, "No existe un usuario con la identificacion " + ID,
						"Usuario no encontrado", JOptionPane.WARNING_MESSAGE);
			}
		}

	}

}
