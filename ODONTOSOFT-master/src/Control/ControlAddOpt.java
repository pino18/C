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

public class ControlAddOpt implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String USER = PanelAddOpt.USER.getText();
		if (e.getActionCommand().equals(InterfazVista.ACEPTAR)) {
			try {
				if (!USER.equals("")) {
					ArrayList<String> useropt = SeeOpt.ejecutar(USER);
					ArrayList<String> allopt = OpcionDeMenu.seeAllOperations2();
					
					VentanaPP.contenedor.removeAll();
					VentanaPP.contenedor.add(new PanelAddOpt(allopt,useropt,USER));
					PanelAddOpt.USER2=USER;
					PanelAddOpt.USER.setText("");
					VentanaPP.ventana.pack();
				}else {
					JOptionPane.showMessageDialog(null, "El campo nombre de usuario no fue llenado","Campo vacio", JOptionPane.WARNING_MESSAGE);
				}
				if(!PanelAddOpt.CB.isEmpty()) {
					ArrayList<JCheckBox> CB = PanelAddOpt.CB;
					int I;
					for(I=0;I<CB.size();I++) {
						JCheckBox AUX = CB.get(I);
						if(AUX.isEnabled()) {
							if(AUX.isSelected()) {
								AddOpt.ejecutar(AUX.getName(),PanelAddOpt.USER2);
							}
						}
					}
					JOptionPane.showMessageDialog(null, "Las opciones han sido añadidas","ADICION EXITOSA", JOptionPane.INFORMATION_MESSAGE);
					VentanaPP.contenedor.removeAll();
					VentanaPP.contenedor.add(new PanelLogin());
					VentanaPP.ventana.pack();
				}

			} catch (NotFoundException EX) {
				JOptionPane.showMessageDialog(null, "No existe un usuario " + USER,"Usuario no encontrado", JOptionPane.WARNING_MESSAGE);
			}
		}

	}

}
