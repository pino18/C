package Control;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;

import View.PanelCancelarCita;
import View.PanelRegistrar;
import View.VentanaPP;
import View.FieldPanel.FieldPanel;

public class ControlCancelarCita implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		String op = (String) e.getItem();
		ArrayList<String>formul = new ArrayList();
		if(op.equals("Por Fecha")) {
			formul.add("Ingresar Fecha: DD/MM/AAAA");
			formul.add("Ingrese Hora: HH:MM");
			
			
			PanelCancelarCita.PP.remove(PanelCancelarCita.Field);
			PanelCancelarCita.PP.remove(PanelCancelarCita.PF);
			PanelCancelarCita.Field= new FieldPanel("Parametros",formul,"Valor",null,null);
			PanelCancelarCita.PP.add(PanelCancelarCita.Field, BorderLayout.CENTER);
			PanelCancelarCita.PP.add(PanelCancelarCita.PF, BorderLayout.SOUTH);
			VentanaPP.ventana.pack();
			
		}
		else if(op.equals("Por numero")) {
			formul.add("Ingrse El Numero de su Cita: ");
			PanelCancelarCita.PP.remove(PanelCancelarCita.Field);
			PanelCancelarCita.PP.remove(PanelCancelarCita.PF);
			PanelCancelarCita.Field= new FieldPanel("Parametros",formul,"Valor",null,null);
			PanelCancelarCita.PP.add(PanelCancelarCita.Field, BorderLayout.CENTER);
			PanelCancelarCita.PP.add(PanelCancelarCita.PF, BorderLayout.SOUTH);
			VentanaPP.ventana.pack();
			
			
		}
		
	}
	

}
