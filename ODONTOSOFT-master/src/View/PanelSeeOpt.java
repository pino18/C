package View;

import javax.swing.*;

import Control.ControlMenu;
import Control.ControlSeeOpt;

import java.awt.*;
import java.util.ArrayList;

/*En este panel se pueden vizualizar las opciones que el usuario a ingresar tiene*/

public class PanelSeeOpt extends JPanel {
	JButton aceptar;
	JButton volver;
	public static JTextField ID;

	public PanelSeeOpt() {
		
		/*Este constructor crea un panel en donde se encuentra un JTextField
		 en donde se ingresa el nombre de usuario y
		 tambien genera los botones aceptar y volver.
		 
		 Es generado por el controlador de la opcion de menu*/
		
		JPanel PP = new JPanel();
		PP.setLayout(new BorderLayout());

		JPanel P1 = new JPanel();
		P1.setLayout(new GridLayout(2, 1, 5, 5));
		P1.add(new JLabel("Vizualizacion de las opciones de usuario"));
		P1.add(new JLabel("Permite obtener las opciones de menu que tiene el usuario que se ingrese"));

		JPanel P2 = new JPanel();
		P2.setLayout(new GridLayout(1, 2, 5, 5));
		P2.add(new JLabel("Ingrese el nombre de usuario"));
		ID = new JTextField("");
		P2.add(ID);

		JPanel P3 = new JPanel();
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
		
		/*Este constructor crea un panel en donde se encuentra un conjunto de JLabels 
		 en donde se visualiza las opciones de menu del nombre de usuario ingresado y
		 tambien genera el boton volver.
		 
		 Es generado por el controlador del panel ver opciones (ControlSeeOpt)*/
		JPanel PP = new JPanel();
		PP.setLayout(new BorderLayout());
		
		JPanel P1 = new JPanel();
		P1.setLayout(new GridLayout(4,1,10,10));
		P1.add(new JLabel("Vizualizacion de las opciones de usuario"));
		P1.add(new JLabel("Permite obtener las opciones de menu que tiene el usuario que se ingrese"));
		P1.add(new JLabel("Las opciones de menu de usuario "+ID.getText()+" son:"));
		P1.add(new JLabel(""));

		JPanel P2 = new JPanel();
		P2.setLayout(new GridLayout(A.size()+1,1,5,5));
		int I;
		for(I=0;I<A.size();I++){
			P2.add(new JLabel((A.get(I))));
		}P2.add(new JLabel(""));
		
		JPanel P3 = new JPanel();
		volver = new JButton("Volver");
		volver.setActionCommand(InterfazVista.CANCELAR);
		volver.addActionListener(new ControlMenu());
		P3.add(volver);
		
		PP.add(P1, BorderLayout.NORTH);
		PP.add(P2, BorderLayout.CENTER);
		PP.add(P3, BorderLayout.SOUTH);
		this.add(PP);
	}
}
