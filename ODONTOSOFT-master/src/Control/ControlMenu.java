package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BaseDatos.Data;
import View.InterfazVista;
import View.PanelInicio;
import View.PanelPagarRecibo;
import View.PanelValoracion;
import View.VentanaPP;
import gestorAplicacion.users.User;

public class ControlMenu implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String option = e.getActionCommand();
		
		if (option.equals(InterfazVista.SALIR)) {
			User.currentUser=null;
			Data.saveData();
			VentanaPP.contenedor.removeAll();
			VentanaPP.menuBarra.removeAll();
			VentanaPP.contenedor.add(new PanelInicio());
			VentanaPP.ventana.pack();
		}
		else if (option.equals(InterfazVista.PAGARRECIBO)) {
			
			VentanaPP.contenedor.removeAll();
			VentanaPP.contenedor.add(new PanelPagarRecibo());
			VentanaPP.ventana.pack();
		}
	}
}
