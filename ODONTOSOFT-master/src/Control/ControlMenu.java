package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import BaseDatos.Data;
import View.InterfazVista;
import View.PanelConsultarHistoria;
import View.PanelInicio;
import View.PanelLogin;
import View.PanelPagarRecibo;
import View.PanelValoracion;
import View.VentanaPP;
import View.FieldPanel.FieldPanel;
import gestorAplicacion.documents.HistoriaClinica;
import gestorAplicacion.users.Paciente;
import gestorAplicacion.users.User;

public class ControlMenu implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String option = e.getActionCommand();
		if (option.equals(InterfazVista.CANCELAR)) {
			VentanaPP.contenedor.removeAll();
			VentanaPP.contenedor.add(new PanelLogin());
			VentanaPP.ventana.pack();
		}
		else if (option.equals(InterfazVista.SALIR)) {
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
		else if(option.equals(InterfazVista.HISTORIA)){
			Paciente U = (Paciente) User.currentUser;
			HistoriaClinica HC = Data.historias.get(U.getIdentificacion());
			ArrayList<String> labels = new ArrayList();
			labels.add("Identificacion");
			labels.add("Nombre del Paciente");
			labels.add("Numero de citas realizadas");
			labels.add("Informacion a tener en cuenta");
			ArrayList<String> value = new ArrayList();
			value.add(U.getIdentificacion());
			value.add(U.getFullname());
			value.add(Integer.toString(HC.getNroCitasRealizadas()));
			value.add(HC.getInformacion());
			ArrayList<Boolean> HAB = new ArrayList();
			HAB.add(false);HAB.add(false);HAB.add(false);HAB.add(false);
			FieldPanel FP = new FieldPanel("Campo",labels,"Valor",value,HAB);
			VentanaPP.contenedor.removeAll();
			VentanaPP.contenedor.add(new PanelConsultarHistoria(FP));
			VentanaPP.ventana.pack();
		}
	}
}
