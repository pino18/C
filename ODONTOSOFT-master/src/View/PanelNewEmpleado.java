package View;

import java.awt.*;
import javax.swing.*;

import Control.ControlNewEmpleado;
import Control.ControlPagarRecibo;
import View.FieldPanel.FieldPanel;

public class PanelNewEmpleado extends JPanel {
	JButton aceptar;
	JButton cancelar;

	public PanelNewEmpleado(FieldPanel FP) {

		JPanel PP = new JPanel();
		PP.setLayout(new BorderLayout(7, 7));

		JPanel P1 = new JPanel();
		P1.add(new JLabel("Creacion de un nuevo usuario"));

		JPanel P2 = new JPanel();
		P2.add(new JLabel("Permite crear un nuevo usuario de tipo empleado"));

		JPanel P3 = new JPanel();
		P3.setLayout(new BorderLayout(7, 7));
		P3.add(FP, BorderLayout.CENTER);

		JPanel P4 = new JPanel();
		P4.setLayout(new GridLayout(1, 2, 5, 5));
		aceptar = new JButton(InterfazVista.ACEPTAR);
		aceptar.addActionListener(new ControlNewEmpleado());
		cancelar = new JButton(InterfazVista.CANCELAR);
		cancelar.addActionListener(new ControlNewEmpleado());

		P4.add(aceptar);
		P4.add(cancelar);

		P3.add(P4, BorderLayout.SOUTH);

		PP.add(P1, BorderLayout.NORTH);
		PP.add(P2, BorderLayout.CENTER);
		PP.add(P3, BorderLayout.SOUTH);
		this.setLayout(new BorderLayout());
		this.add(PP, BorderLayout.CENTER);
	}
}
