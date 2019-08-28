package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import View.InterfazVista;
import View.PanelAddOpt;
import View.PanelLogin;
import View.VentanaPP;
import errorAplication.NotFoundException;
import uiMain.OpcionDeMenu;
import uiMain.operations.AddOpt;
import uiMain.operations.SeeOpt;

//Este controlador premite modificar el panel de añadir opciones al usuario

public class ControlAddOpt implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String USER = PanelAddOpt.USER.getText();
		if (e.getActionCommand().equals(InterfazVista.ACEPTAR)) {
			try {
				if (PanelAddOpt.SW == 1) {
					if (!USER.equals("")) {
						/*Este if valida que la persona llene 
						el campo nombre de usuario del panel ver opciones*/
						
						/*A continuacion se obtienen dos ArrayList
						 donde estan todas las opciones de menu existentes
						 y las que solo posee el usuario ingresado*/
						
						ArrayList<String> useropt = SeeOpt.ejecutar(USER);
						ArrayList<String> allopt = OpcionDeMenu.seeAllOperations2();
						
						/*la variable SW permite acceder a 
						alguna de las dos opciones de este controlador*/
						PanelAddOpt.SW = 2;
						
						VentanaPP.contenedor.removeAll();
						VentanaPP.contenedor.add(new PanelAddOpt(allopt, useropt, USER));
						PanelAddOpt.USER.setText("");
						VentanaPP.ventana.pack();
					} else {
						/*Arroja una ventana emergente en caso de que la persona
						 no llene el campo nombre de usuario donde da una alerta*/
						JOptionPane.showMessageDialog(null, "El campo nombre de usuario no fue llenado", "Campo vacio",
								JOptionPane.WARNING_MESSAGE);
					}
				} else if (PanelAddOpt.SW == 2) {
					/*Aqui se obtienen los valores de los checkbox existentes en
					  panel añadir opciones a usuario (PanelAddOpt)
					  para poder ir al modelo y cumplir con su funcion*/
					
					ArrayList<JCheckBox> CB = PanelAddOpt.CB;
					int I;
					for (I = 0; I < CB.size(); I++) {
						JCheckBox AUX = CB.get(I);
						if (AUX.isEnabled()) {
							if (AUX.isSelected()) {
								AddOpt.ejecutar(AUX.getName(), USER);
							}
						}
					}
					JOptionPane.showMessageDialog(null, "Las opciones han sido añadidas", "ADICION EXITOSA",
							JOptionPane.INFORMATION_MESSAGE);
					PanelAddOpt.SW = 1;
					VentanaPP.contenedor.removeAll();
					VentanaPP.contenedor.add(new PanelLogin());
					VentanaPP.ventana.pack();
				}

			} catch (NotFoundException EX) {
				/*Este catch se encarga de arrojar una ventana emergente
				  en caso de que el programa arroje un error por haber 
				  ingresado un nombre de usuario que no existe*/
				JOptionPane.showMessageDialog(null, "No existe un usuario " + USER, "Usuario no encontrado",
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}

}
