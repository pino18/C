package View;

import javax.swing.*;

import Control.ControlAddOpt;
import Control.ControlMenu;
import Control.ControlSeeOpt;

import java.awt.*;
import java.util.ArrayList;

/*En este panel se pueden añadir las opciones al usuario ingresado, marcando checkbox*/

public class PanelAddOpt extends JPanel {
	/*Este constructor crea un panel en donde se encuentra un JTextField
	 en donde se ingresa el nombre de usuario y
	 tambien genera los botones aceptar y volver.
	 
	 Es generado por el controlador de la opcion de menu*/
	JButton aceptar;
	JButton volver;
	int I;
	public static int SW=1;
	public static JTextField USER;
	public static ArrayList<JCheckBox> CB = new ArrayList<JCheckBox>();
	
	public PanelAddOpt() {
		JPanel PP = new JPanel();
		PP.setLayout(new BorderLayout());

		JPanel P1 = new JPanel();
		P1.setLayout(new GridLayout(2, 1, 5, 5));
		P1.add(new JLabel("Añadir opciones de usuario"));
		P1.add(new JLabel("Permite obtener las opciones de menu que tiene el usuario que se ingrese y añadirle"));

		JPanel P2 = new JPanel();
		P2.setLayout(new GridLayout(1, 2, 5, 5));
		P2.add(new JLabel("Ingrese el nombre del usuario"));
		USER = new JTextField("");
		P2.add(USER);

		JPanel P3 = new JPanel();
		aceptar = new JButton(InterfazVista.ACEPTAR);
		aceptar.addActionListener(new ControlAddOpt());
		volver = new JButton(InterfazVista.CANCELAR);
		volver.addActionListener(new ControlMenu());
		P3.add(aceptar);
		P3.add(volver);
		PP.add(P1, BorderLayout.NORTH);
		PP.add(P2, BorderLayout.CENTER);
		PP.add(P3, BorderLayout.SOUTH);
		this.add(PP);
	}
	public PanelAddOpt(ArrayList<String> A, ArrayList<String> U,String USER) {
		/*Este constructor crea un panel en donde se encuentra un conjunto de Checkbox 
		 en donde se visualiza las opciones de menu del nombre de usuario ingresado
		 y permitira marcar aquellas que no esten marcadas para añadirselas al usuario,
		 tambien genera el boton volver.
		 
		 Es generado por el controlador del panel añadir opciones (ControlAddOpt)*/
		
		JPanel PP = new JPanel();
		PP.setLayout(new BorderLayout());

		JPanel P1 = new JPanel();
		P1.setLayout(new GridLayout(4, 1, 5, 5));
		P1.add(new JLabel("Añadir opciones de usuario"));
		P1.add(new JLabel("Permite obtener las opciones de menu que tiene el usuario que se ingrese y añadirle"));
		P1.add(new JLabel("Seleccione las opciones que le desea añadir al usuario "+USER+":"));
		P1.add(new JLabel(""));
		
		JPanel P2 = new JPanel();
		P2.setLayout(new GridLayout(A.size()+1, 1, 5, 5));
		
		for(I=0;I<A.size();I++) {
			JCheckBox AUX = new JCheckBox(A.get(I));
			if(U.contains(A.get(I))) {
				AUX.setSelected(true);
				AUX.setEnabled(false);
			}else {
				AUX.setEnabled(true);
			}
			P2.add(AUX);
			CB.add(AUX);
		}
		P2.add(new JLabel(""));

		JPanel P3 = new JPanel();
		aceptar = new JButton(InterfazVista.ACEPTAR);
		aceptar.addActionListener(new ControlAddOpt());
		volver = new JButton(InterfazVista.CANCELAR);
		volver.addActionListener(new ControlMenu());
		P3.add(aceptar);
		P3.add(volver);
		PP.add(P1, BorderLayout.NORTH);
		PP.add(P2, BorderLayout.CENTER);
		PP.add(P3, BorderLayout.SOUTH);
		this.add(PP);
	}
}
