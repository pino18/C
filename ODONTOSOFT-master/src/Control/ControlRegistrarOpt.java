package Control;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import View.PanelRegistrar;
import View.PanelVoid;
import View.VentanaPP;
import View.FieldPanel.FieldPanel;

public class ControlRegistrarOpt implements ItemListener{

	@Override
	public void itemStateChanged(ItemEvent e) {
		String op = (String) e.getItem();
		ArrayList<String>labels = new ArrayList();
		if (op.equals("Paciente")) {
			
			labels.add("Identificación");
			labels.add("Nombre completo");
			labels.add("Edad");
			labels.add("Telefono");
			labels.add("Sexo");
			labels.add("Nombre de usuario");
			labels.add("E-mail");
			labels.add("Contraseña");
			
			PanelRegistrar.PP.remove(PanelRegistrar.Field);
			PanelRegistrar.Field= new FieldPanel("Campo",labels,"Valor",null,null);
			PanelRegistrar.PP.add(PanelRegistrar.Field, BorderLayout.CENTER);
			VentanaPP.ventana.pack();
		}
		else if (op.equals("Acompañante")) {
			labels.add("Identificación");
			labels.add("Nombre completo");
			labels.add("Edad");
			labels.add("Telefono");
			labels.add("Sexo");
			labels.add("Nombre de usuario");
			labels.add("E-mail");
			labels.add("Contraseña");
			labels.add("Usuario al que acompaña");
			labels.add("Parentezco");
			
			PanelRegistrar.PP.remove(PanelRegistrar.Field);
			PanelRegistrar.Field= new FieldPanel("Campo",labels,"Valor",null,null);
			PanelRegistrar.PP.add(PanelRegistrar.Field, BorderLayout.CENTER);
			VentanaPP.ventana.pack();
		}
		else if(op.equals("---")) {
			
			PanelRegistrar.PP.remove(PanelRegistrar.Field);
			PanelRegistrar.Field= new FieldPanel();
			PanelRegistrar.PP.add(PanelRegistrar.Field, BorderLayout.CENTER);
			VentanaPP.ventana.pack();
		}
	}
	
	
}
