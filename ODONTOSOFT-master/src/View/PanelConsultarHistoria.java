package View;

import javax.swing.*;

import gestorAplicacion.documents.HistoriaClinica;
import gestorAplicacion.users.Paciente;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import View.FieldPanel.FieldPanel;

public class PanelConsultarHistoria extends JPanel {
	
	public PanelConsultarHistoria(FieldPanel FP) {
		JPanel PP = new JPanel();
		PP.setLayout(new BorderLayout(7,7));
		JPanel P1 = new JPanel();
		P1.add(new JLabel("Visualización de la historia clínica"));
		JPanel P2 = new JPanel();
		P2.add(new JLabel("Permite obtener la informacion referente a la historia clinica del paciente tal como se muestra a continuación:"));
		PP.add(P1, BorderLayout.NORTH);
		PP.add(P2, BorderLayout.CENTER);
		PP.add(FP, BorderLayout.SOUTH);
		this.setLayout(new BorderLayout());
		this.add(PP, BorderLayout.CENTER);
	}
	
}
