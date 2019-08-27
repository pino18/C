package View;

import javax.swing.*;

import Control.ControlMenu;
import Control.ControlNewEmpleado;
import Control.ControlPagarRecibo;
import gestorAplicacion.documents.HistoriaClinica;
import gestorAplicacion.users.Paciente;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import View.FieldPanel.FieldPanel;

public class PanelConsultarHistoria extends JPanel {
	JButton volver;
	public PanelConsultarHistoria(FieldPanel FP) {
		
		
		JPanel PP = new JPanel();
		PP.setLayout(new BorderLayout(7,7));
		
		JPanel P1 = new JPanel();
		P1.setLayout(new GridLayout(3,1,5,5));
		JLabel title = new JLabel("Visualización de la historia clínica");
		title.setSize(100, 100);
		String[] description1 = {"Permite obtener la informacion referente a la historia clinica","del paciente tal como se muestra a continuación:"};
		P1.add(title);
		P1.add(new JLabel(description1[0]));
		P1.add(new JLabel(description1[1]));
		
		JPanel P3 = new JPanel();
		volver = new JButton(InterfazVista.VOLVER);
		volver.setActionCommand(InterfazVista.CANCELAR);
		volver.addActionListener(new ControlMenu());
		P3.add(volver);

		PP.add(P1, BorderLayout.NORTH);
		PP.add(FP, BorderLayout.CENTER);
		PP.add(P3, BorderLayout.SOUTH);
		this.add(PP);
	}
	
}
