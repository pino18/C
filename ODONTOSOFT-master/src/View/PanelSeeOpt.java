package View;

import javax.swing.*;

import Control.ControlMenu;
import Control.ControlSeeOpt;

import java.awt.*;
import java.util.ArrayList;

public class PanelSeeOpt extends JPanel {
	JButton aceptar;
	JButton volver;
	public static JTextField ID;

	public PanelSeeOpt() {
		JPanel PP = new JPanel();
		PP.setLayout(new BorderLayout());

		JPanel P1 = new JPanel();
		P1.setLayout(new GridLayout(2, 1, 5, 5));
		P1.add(new JLabel("Vizualizacion de las opciones de usuario"));
		P1.add(new JLabel("Permite obtener las opciones de menu que tiene el usuario que se ingrese"));

		JPanel P2 = new JPanel();
		P2.setLayout(new GridLayout(1, 2, 5, 5));
		P2.add(new JLabel("Ingrese la identificación del usuario"));
		ID = new JTextField();
		P2.add(ID);

		JPanel P3 = new JPanel();
		P3.setLayout(new GridLayout(1, 2, 5, 5));
		aceptar = new JButton(InterfazVista.ACEPTAR);
		aceptar.addActionListener(new ControlSeeOpt());
		volver = new JButton(InterfazVista.CANCELAR);
		volver.addActionListener(new ControlMenu());
		P3.add(aceptar);
		P3.add(volver);
		PP.add(P1, BorderLayout.NORTH);
		PP.add(P2, BorderLayout.CENTER);
		PP.add(P3, BorderLayout.SOUTH);
		this.add(PP);
	}

	public PanelSeeOpt(ArrayList<String> A) {
		JPanel PP = new JPanel();
		
		JPanel P1 = new JPanel();
		P1.setLayout(new GridLayout(3,1,5,5));
		P1.add(new JLabel("Vizualizacion de las opciones de usuario"));
		P1.add(new JLabel("Permite obtener las opciones de menu que tiene el usuario que se ingrese"));
		P1.add(new JLabel("Las opciones de menu de usuario con identificacion"+ID+"son:"));

		JPanel P2 = new JPanel();
		P2.setLayout(new GridLayout(2,20,5,5));
		int I;
		for(I=0;I<A.size();I++){
			P2.add(new JLabel((A.get(I))));
		}
		
		JPanel P3 = new JPanel();
		P3.setLayout(new GridLayout(1,2,5,5));
		volver = new JButton(InterfazVista.CANCELAR);
		volver.addActionListener(new ControlMenu());
		P3.add(volver);
		PP.add(P1, BorderLayout.NORTH);
		PP.add(P2, BorderLayout.CENTER);
		PP.add(P3, BorderLayout.SOUTH);
		this.add(PP);
	}
}
