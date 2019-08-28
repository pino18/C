package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JOptionPane;

import BaseDatos.Data;
import View.PanelLogin;
import View.PanelRegistrar;
import View.PanelRemoveOpt;
import View.PanelRenunciar;
import View.VentanaPP;
import View.FieldPanel.FieldPanel;
import gestorAplicacion.documents.Cita;
import gestorAplicacion.users.Empleado;
import gestorAplicacion.users.User;

public class ControlRenunciar implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
//Se ace la verificacion del usuario y la contraseña, hecho esto si el empleado es un medico
//se reparten las citas que este ya tenian, para qeu se pueda atender a las personas qeu con anterioridad 
//habian solicitado una		
		Empleado E = (Empleado) User.currentUser;
		ArrayList<String> values = PanelRenunciar.Field.getValues();
		String username = values.get(0);
		String Password=values.get(1);
		if (username.contentEquals(E.getUsername()) && Password.equals(E.getPassword())) {
			E = (Empleado) Data.users.get(username);
			if (E.getCargo().equals("medico")) {
				for (Map.Entry<String, Cita> Cita : Data.citas.entrySet()) {
					Cita CObj = Cita.getValue();
					if (CObj.getEmpleado().equals(username) && CObj.getEstado().equals("pendiente")) {
						String N = CObj.getNroCita();
						Data.citasByN.remove(N);
						Data.citas.remove(CObj.getFecha() + CObj.getHora());
					}
				}
			}
			Data.users.remove(username);
			JOptionPane.showMessageDialog(null, "El usuario Ha renunciado", "Ya no haces parte de ODONTOSOFT", JOptionPane.INFORMATION_MESSAGE);
			values.clear();
			VentanaPP.contenedor.removeAll();
			VentanaPP.contenedor.add(new PanelLogin());
			VentanaPP.ventana.pack();
			PanelRegistrar.Field = new FieldPanel();
		}
		else {
			JOptionPane.showMessageDialog(null, "Validacion fallidad, por favor ingrese los datos nuevamente", "ERROR", JOptionPane.ERROR_MESSAGE);
			values.clear();
		}
		
	}
	
	

}
