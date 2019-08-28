package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BaseDatos.Data;
import View.PanelCancelarCita;
import View.PanelInicio;
import View.PanelLogin;
import View.PanelRegistrar;
import View.VentanaPP;
import View.FieldPanel.FieldPanel;
import gestorAplicacion.documents.Cita;

public class ControlCancelarCitaenviar implements ActionListener {
//en este control se acaban de recibir los parametros necesarios para lugo hacer lo mismo qeu se hacia 
//en operations, o los que se hacia cuando era por menu de consola
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// TODO Auto-generated method stub
		if(PanelCancelarCita.como.equals("Por Fecha")) {
			ArrayList<String> values = PanelCancelarCita.Field.getValues();
			if(values.contains("")) {
				JOptionPane.showMessageDialog(null, "No has llenado todos los campos", "ERROR", JOptionPane.ERROR_MESSAGE);
				values.clear();
			}
			else {
				String f=values.get(0);
				String h=values.get(1);
				Cita C = Data.citas.get(f+h);
//se borra la cita de las bases de datos 				
				Data.citas.remove(f+h);
				Data.citasByN.remove(C.getNroCita());
				values.clear();
				JOptionPane.showMessageDialog(null, "Cancelacion Exitosa", "Cancelacion", JOptionPane.INFORMATION_MESSAGE);
//se devuelve a la vista orignial para que el usuario siga haciendo uso de la plataforma 				
				VentanaPP.contenedor.removeAll();
				VentanaPP.contenedor.add(new PanelLogin());
				VentanaPP.ventana.pack();
				PanelRegistrar.Field = new FieldPanel();
			}
		
		}
		else if(PanelCancelarCita.como.equals("Por Numero")) {
			ArrayList<String> values = PanelCancelarCita.Field.getValues();
			if(values.contains("")) {
				JOptionPane.showMessageDialog(null, "Por favor digite el numero de la cita", "ERROR", JOptionPane.ERROR_MESSAGE);
				values.clear();
			}
			else {
				String no=values.get(0);
				Cita C = Data.citasByN.get(no);
				Data.citasByN.remove(no);
				String FH= C.getFecha()+C.getHora();
				Data.citas.remove(FH);
				values.clear();
				JOptionPane.showMessageDialog(null, "Cancelacion Exitosa", "Cancelacion", JOptionPane.INFORMATION_MESSAGE);
				VentanaPP.contenedor.removeAll();
				VentanaPP.contenedor.add(new PanelLogin());
				VentanaPP.ventana.pack();
				PanelRegistrar.Field = new FieldPanel();
				
			}
			
			
		}
	}

}
