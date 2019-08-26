package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.VentanaPP;

public class ControlMenu implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String option = e.getActionCommand();
		VentanaPP.contenedor.removeAll();
		
		if (option.equals("Iniciar Sesión")) {
			
		}

	}
}
