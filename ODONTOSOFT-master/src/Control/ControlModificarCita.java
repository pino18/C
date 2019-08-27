package Control;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;

import View.PanelCancelarCita;
import View.PanelModificarCita;
import View.VentanaPP;
import View.FieldPanel.FieldPanel;

public class ControlModificarCita implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		String op = (String) e.getItem();
		JComboBox<String> option1 = new JComboBox<String>() ;
		if(op.equals("Cambiar El Estado De Una Cita")) {
			option1.addItem("---");
			option1.addItem("Pendiente");
			option1.addItem("Realizada");
			
			
			PanelModificarCita.PP.remove(PanelModificarCita.Field);
			PanelModificarCita.PP.remove(PanelModificarCita.PF);
			PanelModificarCita.Field.removeAll();
			PanelModificarCita.Field.add(option1);
			PanelModificarCita.PP.add(PanelModificarCita.Field, BorderLayout.CENTER);
			PanelModificarCita.PP.add(PanelModificarCita.PF, BorderLayout.SOUTH);
			VentanaPP.ventana.pack();
			
		}
		else if(op.equals("Ingresar El Procedimiento Realizado En La Cita")) {
			
			PanelModificarCita.PP.remove(PanelModificarCita.Field);
			PanelModificarCita.PP.remove(PanelModificarCita.PF);
			PanelModificarCita.Field.removeAll();
			PanelModificarCita.Field.add(new JTextArea(10,30));
			PanelModificarCita.PP.add(PanelModificarCita.Field, BorderLayout.CENTER);
			PanelModificarCita.PP.add(PanelModificarCita.PF, BorderLayout.SOUTH);
			VentanaPP.ventana.pack();
			
			
		}
		
	}
	

}
